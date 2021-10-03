package com.steleot.jetpackcompose.playground.di

import android.app.Activity
import androidx.activity.ComponentActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.steleot.jetpackcompose.playground.R
import com.steleot.jetpackcompose.playground.helpers.InAppUpdateHelper
import com.steleot.jetpackcompose.playground.helpers.InAppUpdateHelperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object ActivityModule {

    @Provides
    @ActivityScoped
    fun provideComponentActivity(
        activity: Activity
    ) = activity as ComponentActivity

    @Provides
    @ActivityScoped
    fun provideAppUpdateManager(
        activity: Activity
    ): AppUpdateManager = AppUpdateManagerFactory.create(activity)

    @Provides
    @ActivityScoped
    fun provideInAppUpdateHelper(
        activity: ComponentActivity,
        appUpdateManager: AppUpdateManager
    ): InAppUpdateHelper = InAppUpdateHelperImpl(activity, appUpdateManager)

    @Provides
    @ActivityScoped
    fun provideGoogleSignInClient(
        activity: Activity,
    ): GoogleSignInClient {

        val options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(activity.getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        return GoogleSignIn.getClient(activity, options)
    }
}