package com.zarinpal.libs.cardviwepager;

import android.support.annotation.LayoutRes;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Base Card View ViewPager Item Created by farshid roohi on 12/12/17.
 */

public abstract class BaseCardViewPagerItem<T> extends PagerAdapter implements CardElevationMax {

    private List<CardView> views;
    private List<T> models;
    private float baseElevation;
    private CardView cardView;
    private int marginLeft = 10;
    private int marginTop = 10;
    private int marginRight = 10;
    private int marginBottom = 10;

    @LayoutRes
    public abstract int getLayout();

    public abstract void bindView(View view, T item);

//    public abstract ViewPager getViewPager();
//
//    public abstract C getAdapter();

    public BaseCardViewPagerItem() {
        this.views = new ArrayList<>();
        this.models = new ArrayList<>();
    }

    public void addCardItem(T item) {
        this.views.add(null);
        this.models.add(item);
    }

    public T getItem(int position) {
        return this.models.get(position);
    }

    @Override
    public float getBaseElevation() {
        return baseElevation;
    }

    @Override
    public CardView getCardViewAt(int position) {
        return this.views.get(position);
    }

    @Override
    public int getCount() {
        return this.models.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View rootView = LayoutInflater.from(container.getContext()).inflate(R.layout.default_card_view_pager, container, false);
        CardView cardView = rootView.findViewById(R.id.card_view_pager);
        View viewInflater = LayoutInflater.from(container.getContext()).inflate(getLayout(), cardView, false);
        container.addView(rootView);
        cardView.addView(viewInflater);
        cardView.setCardElevation(1);

        this.bindView(rootView, this.models.get(position));
        if (baseElevation == 0) {
            baseElevation = cardView.getCardElevation();
        }

        cardView.setMaxCardElevation(baseElevation * MAX_ELEVATION_FACTOR);
        views.set(position, cardView);



        return rootView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
        views.set(position, null);
    }

    public void setMarginItem(int left, int top, int right, int bottom) {
       this.marginLeft = left;
       this.marginTop = top;
       this.marginRight = right;
       this.marginBottom = bottom;
    }
}