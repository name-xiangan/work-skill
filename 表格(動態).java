 TextView tv = new TextView(this.getContext());
            tv.setText(ConfigInfo.m_Sympton.get(i).desc);
            tv.setGravity(Gravity.CENTER);

            tv.setBackgroundColor(Color.GRAY);
            tv.setWidth(MainActivity.dpToPx(240));
            tv.setHeight(120);
            tv.setBackground(this.getResources().getDrawable(R.drawable.table_item));
            tab.addView(tv);

            int w=tv.getWidth();

            ViewGroup.LayoutParams params=tv.getLayoutParams();


            params.width=10;

            Log.d("W", String.valueOf(w));

            ViewGroup.LayoutParams ll = tv.getLayoutParams();
            ll.width = MainActivity.dpToPx(100);
            ll.height = 120;

            LinearLayout linearLayout = new LinearLayout(this.getContext());
            linearLayout.setLayoutParams(ll);

            ImageView iv = new ImageView(this.getContext());
            iv.setAdjustViewBounds(true);
            new ImageDownloaderTask(iv).execute(ConfigInfo.m_Sympton.get(i).photo);
            iv.setBackgroundColor(Color.GRAY);
            iv.setForegroundGravity(Gravity.CENTER);
            iv.setLayoutParams(params);
            iv.setMaxWidth(80);
            iv.setBackground(this.getResources().getDrawable(R.drawable.table_item));

            linearLayout.addView(iv);
            linearLayout.setGravity(Gravity.CENTER);
            linearLayout.setBackground(this.getResources().getDrawable(R.drawable.table_item));

            tab.addView(linearLayout);
            tab.setGravity(Gravity.CENTER);