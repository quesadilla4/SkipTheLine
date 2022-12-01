package com.example.skiptheline;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;


public class VendorAnalyticsActivity extends AppCompatActivity {

    PieChart pieChart;
    TextView tv1,tv2,tv3,tv4;
    TextView tvTitle1,tvTitle2;
    ImageButton btnFilter, btnHome, btnFilter2;
    View sq1, sq2;
    AlertDialog.Builder alertDialog;
    AlertDialog alert, alert2;
    GraphView graphView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_analytics);

        pieChart = findViewById(R.id.piechart);
        tv1 = findViewById(R.id.textViewFirst);
        tv2 = findViewById(R.id.textViewSecond);
        tv3 = findViewById(R.id.textViewThird);
        tv4 = findViewById(R.id.textViewFourth);
        tvTitle1= findViewById(R.id.textViewTitle1);
        tvTitle2= findViewById(R.id.textViewTitle2);
        btnFilter = findViewById(R.id.imageButtonFilter);
        btnFilter2 = findViewById(R.id.imageButtonFilter2);
        btnHome = findViewById(R.id.imageButtonHome);
        sq1 = findViewById(R.id.square3);
        sq2 = findViewById(R.id.square4);
        graphView = findViewById(R.id.idGraphView);
        setupGraph();

        loadItemsPie();
        setUpAlertDialog();
        setUpAlertDialog2();
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert.show();
            }
        });
        btnFilter2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert2.show();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    void setupGraph()
    {
        tvTitle2.setText("Sales VS Time:" );
        // on below line we are adding data to our graph view.
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                // on below line we are adding
                // each point on our x and y axis.
                new DataPoint(0, 1),
                new DataPoint(1, 3),
                new DataPoint(2, 4),
                new DataPoint(3, 9),
                new DataPoint(4, 15),
                new DataPoint(5, 3),
                new DataPoint(6, 6),
                new DataPoint(7, 1),
                new DataPoint(8, 2),
                new DataPoint(10, 8),
                new DataPoint(12, 11)
        });

        // on below line we are adding
        // data series to our graph view.
        graphView.removeAllSeries();
        graphView.addSeries(series);
    }
    void setupGraph2()
    {
        tvTitle2.setText("Drinks VS Time:" );
        // on below line we are adding data to our graph view.
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                // on below line we are adding
                // each point on our x and y axis.
                new DataPoint(0, 7),
                new DataPoint(1, 3),
                new DataPoint(2, 9),
                new DataPoint(3, 2),
                new DataPoint(4, 11),
                new DataPoint(5, 0),
                new DataPoint(6, 6),
                new DataPoint(7, 5),
                new DataPoint(8, 5),
                new DataPoint(10, 8),
                new DataPoint(12, 11)
        });

        // on below line we are adding
        // data series to our graph view.
        graphView.removeAllSeries();
        graphView.addSeries(series);
    }
    void setupGraph3()
    {
        tvTitle2.setText("Credit sales VS Time:");
        // on below line we are adding data to our graph view.
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                // on below line we are adding
                // each point on our x and y axis.
                new DataPoint(0, 10),
                new DataPoint(1, 10),
                new DataPoint(2, 10),
                new DataPoint(3, 10),
                new DataPoint(4, 10),
                new DataPoint(5, 10),
                new DataPoint(6, 11),
                new DataPoint(7, 12),
                new DataPoint(8, 13),
                new DataPoint(10, 14),
                new DataPoint(12, 11)
        });

        // on below line we are adding
        // data series to our graph view.
        graphView.removeAllSeries();
        graphView.addSeries(series);
    }
    void setupGraph4()
    {
        tvTitle2.setText("Discount sales VS Time:" );
        // on below line we are adding data to our graph view.
        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[]{
                // on below line we are adding
                // each point on our x and y axis.
                new DataPoint(0, 1),
                new DataPoint(1, 2),
                new DataPoint(2, 3),
                new DataPoint(3, 4),
                new DataPoint(4, 5),
                new DataPoint(5, 5),
                new DataPoint(6, 4),
                new DataPoint(7, 3),
                new DataPoint(8, 2),
                new DataPoint(10, 1),
                new DataPoint(12, 0)
        });

        // on below line we are adding
        // data series to our graph view.
        graphView.removeAllSeries();
        graphView.addSeries(series);
    }
    private void setUpAlertDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(VendorAnalyticsActivity.this);
        alertDialog.setTitle("Choose data to be displayed:");
        String[] items = {"Sales per Item:","Profit per Item:","Sales per Time:","Sales per Days:"};
        int checkedItem = 0;
        alertDialog.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        loadItemsPie();
                        break;
                    case 1:
                        loadprofitPie();
                        break;
                    case 2:
                        loadsalesperPie();
                        break;
                    case 3:
                        loadsalesweekPie();
                        break;
                }
                dialog.dismiss();
            }
        });
        alert = alertDialog.create();
        alert.setCanceledOnTouchOutside(true);

    }

    private void setUpAlertDialog2() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(VendorAnalyticsActivity.this);
        alertDialog.setTitle("Choose data to be displayed:");
        String[] items = {"Sales VS Time:","Drinks VS Time:","Credit sales VS Time:","Discount sales VS Time:"};
        int checkedItem = 0;
        alertDialog.setSingleChoiceItems(items, checkedItem, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        setupGraph();
                        break;
                    case 1:
                        setupGraph2();
                        break;
                    case 2:
                        setupGraph3();
                        break;
                    case 3:
                        setupGraph4();
                        break;
                }
                dialog.dismiss();
            }
        });
        alert2 = alertDialog.create();
        alert2.setCanceledOnTouchOutside(true);

    }

    private void loadItemsPie() {
        pieChart.clearChart();
        tvTitle1.setText("Sales per Item" );
        pieChart.addPieSlice(
                new PieModel(
                        "Tuna roll (30%)",
                        Integer.parseInt("30"),
                        Color.parseColor("#FFA726")));
        tv1.setText("Tuna roll (30%)");
        pieChart.addPieSlice(
                new PieModel(
                        "California roll (40%)",
                        Integer.parseInt("40"),
                        Color.parseColor("#66BB6A")));
        tv2.setText("California roll (40%)");
        pieChart.addPieSlice(
                new PieModel(
                        "Combo A (20%) ",
                        Integer.parseInt("20"),
                        Color.parseColor("#EF5350")));
        tv3.setText("Combo A (20%) ");
        pieChart.addPieSlice(
                new PieModel(
                        "Combo C (10%) ",
                        Integer.parseInt("10"),
                        Color.parseColor("#29B6F6")));
        tv4.setText("Combo C (10%) ");
        pieChart.startAnimation();
    }
    private void loadprofitPie() {
        pieChart.clearChart();
        tvTitle1.setText("Profit per Item" );
        pieChart.addPieSlice(
                new PieModel(
                        "Tuna roll (25%)",
                        Integer.parseInt("25"),
                        Color.parseColor("#FFA726")));
        tv1.setText("Tuna roll (25%)");
        pieChart.addPieSlice(
                new PieModel(
                        "California roll (45%)",
                        Integer.parseInt("45"),
                        Color.parseColor("#66BB6A")));
        tv2.setText("California roll (45%)");
        pieChart.addPieSlice(
                new PieModel(
                        "Combo A (10%) ",
                        Integer.parseInt("10"),
                        Color.parseColor("#EF5350")));
        tv3.setText("Combo A (10%) ");
        pieChart.addPieSlice(
                new PieModel(
                        "Combo C (20%) ",
                        Integer.parseInt("20"),
                        Color.parseColor("#29B6F6")));
        tv4.setText("Combo C (20%) ");
        pieChart.startAnimation();
    }
    private void loadsalesperPie() {
        tvTitle1.setText("Sales per time:" );
        pieChart.clearChart();
        pieChart.addPieSlice(
                new PieModel(
                        "11AM - 2PM (10%)",
                        Integer.parseInt("10"),
                        Color.parseColor("#FFA726")));
        tv1.setText("11AM - 2PM (10%)");
        pieChart.addPieSlice(
                new PieModel(
                        "2PM - 4PM (50%)",
                        Integer.parseInt("50"),
                        Color.parseColor("#66BB6A")));
        tv2.setText("2PM - 4PM (50%)");
        pieChart.addPieSlice(
                new PieModel(
                        "4PM - 7PM (30%)",
                        Integer.parseInt("30"),
                        Color.parseColor("#EF5350")));
        tv3.setText("4PM - 7PM (30%)");
        pieChart.addPieSlice(
                new PieModel(
                        "7PM - 10PM (20%)",
                        Integer.parseInt("20"),
                        Color.parseColor("#29B6F6")));
        tv4.setText("7PM - 10PM (20%)");
        pieChart.startAnimation();
    }
    private void loadsalesweekPie() {
        tvTitle1.setText("Sales per days:" );
        pieChart.clearChart();
        pieChart.addPieSlice(
                new PieModel(
                        "Workday (80%)",
                        Integer.parseInt("80"),
                        Color.parseColor("#FFA726")));
        tv1.setText("Workday (80%)");
        pieChart.addPieSlice(
                new PieModel(
                        "Weekend (20%)",
                        Integer.parseInt("20"),
                        Color.parseColor("#66BB6A")));
        tv2.setText("Weekend (20%)");

        tv3.setText("");

        tv4.setText(" ");

        sq1.setVisibility(View.INVISIBLE);
        sq2.setVisibility(View.INVISIBLE);
        pieChart.startAnimation();
    }
}