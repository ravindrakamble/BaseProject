package com.r2apps.base.ui.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.r2apps.base.R;
import com.r2apps.base.ui.core.BaseActivity;
import com.r2apps.base.ui.home.MainActivity;
import com.r2apps.base.util.AppConstants;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends BaseActivity implements LoginView, OnClickListener{

    // UI references.
    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new LoginPresenter(this);
        // Set up the login form.
        mEmailView = (AutoCompleteTextView) findViewById(R.id.email);

        mPasswordView = (EditText) findViewById(R.id.password);
        mPasswordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == R.id.login || id == EditorInfo.IME_NULL) {

                    return true;
                }
                return false;
            }
        });

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(this);

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress() {
        mProgressView.setVisibility(View.VISIBLE);
        mLoginFormView.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        mProgressView.setVisibility(View.GONE);
        mLoginFormView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setUsernameError(byte error) {
        switch(error){
            case AppConstants.FieldCheck.EMPTY:
                mEmailView.setError(getString(R.string.error_field_required));
                break;

            case AppConstants.FieldCheck.INCORRECT:
                mEmailView.setError(getString(R.string.error_invalid_email));
                break;

            case AppConstants.FieldCheck.INVALID:
                mEmailView.setError(getString(R.string.error_invalid_email));
                break;
        }
        setFocus(mEmailView);
    }

    @Override
    public void setPasswordError(byte error) {

        switch(error){
            case AppConstants.FieldCheck.EMPTY:
                mPasswordView.setError(getString(R.string.error_field_required));
                break;

            case AppConstants.FieldCheck.INCORRECT:
                mPasswordView.setError(getString(R.string.error_incorrect_password));
                break;

            case AppConstants.FieldCheck.INVALID:
                mPasswordView.setError(getString(R.string.error_invalid_password));
                break;
        }
        setFocus(mPasswordView);
    }

    @Override
    public void navigateToHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        presenter.clear();
        this.finish();
    }

    @Override
    public void onClick(View v) {
        presenter.validateCredentials(mEmailView.getText().toString(), mPasswordView.getText().toString());
    }

    @Override
    public void onResponse(byte requestCode, Object response) {
        Toast.makeText(this, "Response Received", Toast.LENGTH_SHORT).show();
        navigateToHome();
    }

    @Override
    public void onFailure(byte requestCode, byte responseCode, String message) {
        hideProgress();
        Toast.makeText(this, "Error Received", Toast.LENGTH_SHORT).show();
    }
}

