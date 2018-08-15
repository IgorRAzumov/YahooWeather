package com.example.developer.yahooweather.view.screen.splash;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.ImageView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.example.developer.yahooweather.App;
import com.example.developer.yahooweather.R;
import com.example.developer.yahooweather.presenter.SplashPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;

public class SplashScreenActivity extends MvpAppCompatActivity implements SplashView {
    public static final float ALPHA_STEP = 0.1f;
    private static final int MAX_ALPHA = 1;
    private static final float MIN_ALPHA = 0;
    private static final long MILLIS_IN_FUTURE = 2000;
    private static final long COUNT_DOWN_INTERVAL = 100;

    @BindView(R.id.iv_act_splash_screen)
    ImageView splashImageView;

    @InjectPresenter
    SplashPresenter splashPresenter;

    private float imageAlpha = MAX_ALPHA;
    private boolean dataLoaded;

    @ProvidePresenter
    SplashPresenter providePresenter() {
        SplashPresenter presenter = new SplashPresenter(AndroidSchedulers.mainThread());
        App.getInstance().getAppComponent().inject(presenter);
        return presenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ButterKnife.bind(this);
    }

    @Override
    public void startLoadingAnim() {
        CountDownTimer countDownTimer = new CountDownTimer(MILLIS_IN_FUTURE, COUNT_DOWN_INTERVAL) {
            @Override
            public void onTick(long l) {
                splashImageView.setAlpha(imageAlpha);
                imageAlpha -= ALPHA_STEP;
                if (imageAlpha <= MIN_ALPHA) {
                    imageAlpha = MAX_ALPHA;
                }
            }

            @Override
            public void onFinish() {
                imageAlpha = MIN_ALPHA;
                splashImageView.setAlpha(imageAlpha);
                if (!dataLoaded) {
                    this.start();
                }
            }
        };
        countDownTimer.start();
    }

    @Override
    public void setLoading(boolean loading) {
        this.dataLoaded = loading;
    }

    @Override
    public void showErrorLoadWeatherMsg() {

    }

    @Override
    public void showCheckNetworkMessage() {

    }
}
