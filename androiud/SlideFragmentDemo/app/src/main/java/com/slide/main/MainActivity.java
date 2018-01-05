package com.slide.main;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import com.slide.fragment.FiveFragment;
import com.slide.fragment.FourFragment;
import com.slide.fragment.OneFragment;
import com.slide.fragment.R;
import com.slide.fragment.ThreeFragment;
import com.slide.fragment.TwoFragment;
import com.socks.library.KLog;
import com.zhy.autolayout.AutoLayoutActivity;
import java.util.ArrayList;
import java.util.List;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
/**
 * @author fml
 * created at 2016/6/20 13:41
 * description：
 */
public class MainActivity extends AutoLayoutActivity {
    @InjectView(R.id.m_main_viewpager)
    ViewPager mMainViewPager;
    @InjectView(R.id.m_main_fw_btn_true)
    Button mMainFwBtnTrue;
    @InjectView(R.id.m_main_sj_btn_true)
    Button mMainSjBtnTrue;
    @InjectView(R.id.m_main_gz_btn_true)
    Button mMainGzBtnTrue;
    @InjectView(R.id.m_main_lxr_btn_true)
    Button mMainLxrBtnTrue;
    @InjectView(R.id.m_main_wd_btn_true)
    Button mMainWdBtnTrue;
    private Fragment mFragmentOne, mFragmentTwo, mFragmentThree, mFragmentFour, mFragmentFive;
    private FragmentAdapter mFragmentAdapter = null;
    private List<Fragment> mFragmentList = new ArrayList<>();
    private List<Button> mButtonList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initFragment();
        initAdapter();
        changAlpha(0);
    }

    private void initFragment() {
        mFragmentOne = new OneFragment();
        mFragmentTwo = new TwoFragment();
        mFragmentThree = new ThreeFragment();
        mFragmentFour = new FourFragment();
        mFragmentFive = new FiveFragment();
        mFragmentList.add(mFragmentOne);
        mFragmentList.add(mFragmentTwo);
        mFragmentList.add(mFragmentThree);
        mFragmentList.add(mFragmentFour);
        mFragmentList.add(mFragmentFive);

        mButtonList.add(mMainFwBtnTrue);
        mButtonList.add(mMainSjBtnTrue);
        mButtonList.add(mMainGzBtnTrue);
        mButtonList.add(mMainLxrBtnTrue);
        mButtonList.add(mMainWdBtnTrue);
    }
    private void initAdapter() {
        mFragmentAdapter = new FragmentAdapter(getSupportFragmentManager(), mFragmentList);
        mMainViewPager.setAdapter(mFragmentAdapter);
        //viewpager滑动监听
        mMainViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                changAlpha(position, positionOffset);
            }
            @Override
            public void onPageSelected(int position) {
                changAlpha(position);
            }
            @Override
            public void onPageScrollStateChanged(int state) {}
        });
    }

    @OnClick({R.id.m_main_fw_btn_true, R.id.m_main_sj_btn_true, R.id.m_main_gz_btn_true, R.id.m_main_lxr_btn_true, R.id.m_main_wd_btn_true})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.m_main_fw_btn_true:
                mMainViewPager.setCurrentItem(0, false);
                break;
            case R.id.m_main_sj_btn_true:
                mMainViewPager.setCurrentItem(1, false);
                break;
            case R.id.m_main_gz_btn_true:
                mMainViewPager.setCurrentItem(2, false);
                break;
            case R.id.m_main_lxr_btn_true:
                mMainViewPager.setCurrentItem(3, false);
                break;
            case R.id.m_main_wd_btn_true:
                mMainViewPager.setCurrentItem(4, false);
                break;
        }
    }

    private void changAlpha(int postion) {
        for (int i = 0; i < mButtonList.size(); i++) {
            if (i == postion) {
                mButtonList.get(i).setAlpha(1.0f);
                if(null != mFragmentList.get(i).getView()){
                    mFragmentList.get(i).getView().setAlpha(1.0f);
                    mFragmentList.get(i).getView().setScaleX(1.0f);
                    mFragmentList.get(i).getView().setScaleY(1.0f);
                }
            } else {
                mButtonList.get(i).setAlpha(0.0f);
                if(null != mFragmentList.get(i).getView()){
                    mFragmentList.get(i).getView().setAlpha(0.0f);
                    mFragmentList.get(i).getView().setScaleX(0.0f);
                    mFragmentList.get(i).getView().setScaleY(0.0f);
                }
            }
        }
    }

    private void changAlpha(int pos, float posOffset) {
        int nextIndex = pos + 1;
        if(posOffset > 0){
            mButtonList.get(nextIndex).setAlpha(posOffset);
            mButtonList.get(pos).setAlpha(1 - posOffset);
            mFragmentList.get(nextIndex).getView().setAlpha(posOffset);
            mFragmentList.get(pos).getView().setAlpha(1 - posOffset);
            mFragmentList.get(nextIndex).getView().setScaleX(0.5F + posOffset/2);
            mFragmentList.get(nextIndex).getView().setScaleY(0.5F + posOffset/2);
            mFragmentList.get(pos).getView().setScaleX(1-(posOffset/2));
            mFragmentList.get(pos).getView().setScaleY(1-(posOffset/2));
        }
    }
}
