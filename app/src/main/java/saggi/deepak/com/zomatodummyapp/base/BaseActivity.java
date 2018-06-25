package saggi.deepak.com.zomatodummyapp.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import saggi.deepak.com.zomatodummyapp.R;

public abstract class BaseActivity extends AppCompatActivity {

    public Toolbar mToolbar;
    protected int mLayoutId = -1;
    protected Context mContext;
    private ProgressDialog pDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (mLayoutId != -1) {
            setContentView(mLayoutId);
        }

        setPDialog();
        setUpUi(savedInstanceState);

    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        loadData(savedInstanceState);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

    }

    protected abstract void setUpUi(Bundle savedInstanceState);

    protected abstract void loadData(Bundle savedInstanceState);


    private void setPDialog() {
        pDialog = new ProgressDialog(this);
        pDialog.setCancelable(false);
        pDialog.setOnShowListener(dialog -> {
            ProgressBar v = pDialog.findViewById(android.R.id.progress);
            v.getIndeterminateDrawable().setColorFilter(
                    ContextCompat.getColor(BaseActivity.this, R.color.colorAccent),
                    android.graphics.PorterDuff.Mode.MULTIPLY);
        });
    }

    protected void showpDialog(String message) {
        pDialog.setMessage(message);
        if (!pDialog.isShowing()) {
            pDialog.show();
        }
    }

    protected void hidepDialog() {
        if (pDialog != null && pDialog.isShowing()) {
            pDialog.dismiss();
        }
    }

    public void setActionbarTitle(CharSequence title) {
        if (getSupportActionBar() == null) {
            return;
        }
        getSupportActionBar().setTitle(title);
    }

    public boolean isFragmentInBackStack(String pTag) {
        return getSupportFragmentManager().findFragmentByTag(pTag) != null;
    }

    public Fragment getTopFragment(int pContainerId) {
        return getSupportFragmentManager().findFragmentById(pContainerId);
    }

    protected void addFragment(int pContainerId, @NotNull Fragment fragment, String pTag,
                               View pSharedView, @NotNull String pSharedElement, boolean isAddToBackStack) {

        FragmentManager fragmentManager = getSupportFragmentManager();

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (pSharedView != null) {
            transaction.addSharedElement(pSharedView, pSharedElement);
        } else {
            transaction.setCustomAnimations(android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right);
        }
        transaction.replace(pContainerId, fragment);
        if (isAddToBackStack) {
            transaction.addToBackStack(pTag);
        }
        transaction.commit();

    }

    public void popBackStack(String pTag) {
        getSupportFragmentManager().popBackStack(pTag, FragmentManager.POP_BACK_STACK_INCLUSIVE);
    }

}
