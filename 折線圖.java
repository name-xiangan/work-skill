//region linechart

    private void initBarChart(LineChart chart) {

        xAxis = chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setGranularity(1f);

        lYaxis = chart.getAxisLeft();
        rYaxis = chart.getAxisRight();

//        legend = chart.getLegend();
//        legend.setForm(Legend.LegendForm.CIRCLE);
//        legend.setTextSize(11f);
//        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
//        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
//        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
//        legend.setDrawInside(false);

    }

    private void setChart(LineChart chart) {

        chart.setDragEnabled(false);
        chart.setDoubleTapToZoomEnabled(false);
        chart.setTouchEnabled(false);

//        Description description = new Description();
//        description.setText("test");
//        description.setTextColor(Color.GRAY);
//        chart.setDescription(description);

        lYaxis.setAxisMinimum(0);
        lYaxis.setAxisMaximum(100);

        rYaxis.setAxisMinimum(0);
        rYaxis.setAxisMaximum(100);

//        xAxis.setDrawAxisLine(false);
//        lYaxis.setDrawAxisLine(false);
//        rYaxis.setDrawAxisLine(false);

//        rYaxis.setEnabled(false);
//        lYaxis.setEnabled(false);

       // chart.setDrawGridBackground(false);

       // xAxis.setDrawGridLines(false);
        //rYaxis.enableGridDashedLine(10f, 10f, 0f);
        //lYaxis.setDrawGridLines(false);

    }

    private void setData(LineChart chart) {

        int cnt = 4;

        ArrayList<Entry> entries = new ArrayList<>();
        for (int i = cnt; i >= 0; i--) {
            float fvalue = (float) ConfigInfo.HistoryScore.get(i).score;
            entries.add(new Entry(cnt-i, fvalue));
        }

        LineDataSet set = new LineDataSet(entries, "");
        ArrayList<ILineDataSet> sets = new ArrayList<>();
        sets.add(set);

        LineData data = new LineData(sets);

        chart.setData(data);
        chart.invalidate();

    }

    private void dimX(LineChart chart) {

        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                Log.d("Ana-value", value + " ");
                return ConfigInfo.HistoryScore.get((int)(4-value)).date;
            }
        });

        lYaxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return value + "";
            }
        });


    }

    //endregion