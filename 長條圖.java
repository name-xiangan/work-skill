//region bardata
    public void setData(HorizontalBarChart barChart,int k) {

        int cnt=0;
        if (k == 0) {
            cnt = ConfigInfo.m_Allergen.size();
        } else if (k==1) {
            cnt = ConfigInfo.m_Bacterial.size();
        }

        ArrayList<BarEntry> entries1 = new ArrayList<BarEntry>();

        if (k == 0) {
            for (int i = 0; i < cnt; i++) {
                float fvalue = (float) ((ConfigInfo.m_Allergen.get(i).score *100) / ConfigInfo.m_Allergen.get(0).score);
                entries1.add(new BarEntry( i,fvalue));
            }
        } else if (k==1) {
            for (int i = 0; i < cnt; i++) {
                float fvalue = (float) ((ConfigInfo.m_Bacterial.get(i).score * 100) / ConfigInfo.m_Bacterial.get(0).score);
                entries1.add(new BarEntry(i, fvalue));
            }
        }



        BarDataSet set1 = new BarDataSet(entries1, "");

        ArrayList<IBarDataSet> sets = new ArrayList<IBarDataSet>();
        sets.add(set1);



        BarData data = new BarData(sets);
        data.setBarWidth(0.3f);

        barChart.setData(data);
        barChart.invalidate();
    }

    private void initBarChart(HorizontalBarChart barChart,int k) {
        barChart.setBackgroundColor(Color.WHITE);
        //不显示图表网格
        barChart.setDrawGridBackground(false);
        //背景阴影
        barChart.setDrawBarShadow(false);
        barChart.setHighlightFullBarEnabled(false);
        //显示边框
        barChart.setDrawBorders(true);


        /***XY轴的设置***/
        //X轴设置显示位置在底部
        xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //xAxis.setAxisMinimum(0f);
        xAxis.setGranularity(1f);

        lYaxis = barChart.getAxisLeft();
        rYaxis = barChart.getAxisRight();
        //保证Y轴从0开始，不然会上移一点
//        lYaxis.setAxisMinimum(0f);
//        rYaxis.setAxisMinimum(0f);

        /***折线图例 标签 设置***/
        legend = barChart.getLegend();
        legend.setForm(Legend.LegendForm.LINE);
        legend.setTextSize(11f);
        //显示位置
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        //是否绘制在图表里面
        legend.setDrawInside(false);

    }

    private void setChart(HorizontalBarChart barChart,int k) {
        barChart.setDrawBorders(false);

        Description description = new Description();
        description.setEnabled(false);
        barChart.setDescription(description);

        xAxis.setDrawAxisLine(false);
        lYaxis.setDrawAxisLine(false);
        rYaxis.setDrawAxisLine(false);

        rYaxis.setEnabled(false);
        lYaxis.setEnabled(false);

        barChart.setDrawGridBackground(false);

        xAxis.setDrawGridLines(false);
        //rYaxis.enableGridDashedLine(10f, 10f, 0f);
        lYaxis.setDrawGridLines(false);

    }

    private void dimDxis(HorizontalBarChart barChart, int k) {
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                if (k == 0) {
                    return ConfigInfo.m_Allergen.get((int) value % ConfigInfo.m_Allergen.size()).name;
                } else {
                    return ConfigInfo.m_Bacterial.get((int) value % ConfigInfo.m_Bacterial.size()).name;
                }

            }
        });

        lYaxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return ((int) value * 100) + "%";
            }
        });
    }

    //endregion