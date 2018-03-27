package com.example.android.disscussionforum;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thefinestartist.finestwebview.FinestWebView;

/**
 * Created by Hackz on 3/23/18.
 */

public class WebFragment extends Fragment {

    private String url="https://discussions.udacity.com/login";
    public static final String USER_AGENT_FAKE = "@strings/fake_user_for_testing";



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        new FinestWebView.Builder(getActivity()).theme(R.style.FinestWebViewTheme)
                .titleDefault("Udacity Forum")
                .showUrl(false)
                .statusBarColorRes(R.color.bluePrimaryDark)
                .toolbarColorRes(R.color.bluePrimary)
                .titleColorRes(R.color.finestWhite)
                .urlColorRes(R.color.bluePrimaryLight)
                .iconDefaultColorRes(R.color.finestWhite)
                .progressBarColorRes(R.color.finestWhite)
                .showProgressBar(true)
                .progressBarHeight(4)
                .webViewUserAgentString(USER_AGENT_FAKE)               //setting user agent
                .stringResCopiedToClipboard(R.string.copied_to_clipboard)
                .stringResCopiedToClipboard(R.string.copied_to_clipboard)
                .stringResCopiedToClipboard(R.string.copied_to_clipboard)
                .showSwipeRefreshLayout(true)
                .swipeRefreshColorRes(R.color.bluePrimaryDark)
                .menuSelector(R.drawable.selector_light_theme)
                .menuTextGravity(Gravity.CENTER)
                .menuTextPaddingRightRes(R.dimen.defaultMenuTextPaddingLeft)
                .dividerHeight(0)
                .showIconClose(false)
                .showIconForward(true)
                .showIconBack(true)
                .backPressToClose(true)
                .gradientDivider(false)
                .setCustomAnimations(R.anim.slide_up, R.anim.hold, R.anim.hold, R.anim.slide_down)
                .show(url);
        return super.onCreateView(inflater, container, savedInstanceState);

    }

}



