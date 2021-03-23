package com.example.biometrics;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.fragment.app.FragmentActivity;

import java.util.concurrent.Executors;

public class Biometrics {
    private static final String TAG = "myTag";
    private final Context applicationContext;

    public Biometrics(Context context) {
        applicationContext = context;
    }

    public void generateFingerMgr() {
        // Check whether this device can authenticate with biometrics
        if (BiometricManager.from(applicationContext).canAuthenticate(BiometricManager.Authenticators.BIOMETRIC_STRONG) == BiometricManager.BIOMETRIC_SUCCESS) {
            showBiometricPrompt();
        } else {
            // Cannot use biometric prompt
            Toast.makeText(applicationContext, "Cannot use biometric", Toast.LENGTH_SHORT).show();
        }
    }

    private void showBiometricPrompt() {
        BiometricPrompt.AuthenticationCallback authenticationCallback = getAuthenticationCallback();
        BiometricPrompt mBiometricPrompt = new BiometricPrompt((FragmentActivity) applicationContext, Executors.newSingleThreadExecutor(), authenticationCallback);

        BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setDescription("Use your biometric data to verify your identity")
                .setTitle("Confirm your identity")
                .setNegativeButtonText("Cancel")
                .build();

        mBiometricPrompt.authenticate(promptInfo);
    }

    private BiometricPrompt.AuthenticationCallback getAuthenticationCallback() {
        // Callback for biometric authentication result
        return new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                Log.e(TAG, "Error code: " + errorCode + "error String: " + errString);
                super.onAuthenticationError(errorCode, errString);
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        };
    }
}
