package picodiploma.dicoding.warungbekasi;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import picodiploma.dicoding.warungbekasi.adapter.CardViewHidanganAdapter;
import picodiploma.dicoding.warungbekasi.adapter.GridHidanganAdapter;
import picodiploma.dicoding.warungbekasi.adapter.ListHidanganAdapter;
import picodiploma.dicoding.warungbekasi.listener.ItemClickSupport;
import picodiploma.dicoding.warungbekasi.model.Hidangan;
import picodiploma.dicoding.warungbekasi.model.HidanganData;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvCategory;
    private ArrayList<Hidangan> list;
    final String STATE_TITLE = "state_string";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    int mode;
    String title = "Mode List";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list = new ArrayList<>();


        if (savedInstanceState == null) {

            setActionBarTitle(title);
            list.addAll(HidanganData.getListData());
            showRecyclerList();
            mode = R.id.action_list;

        } else {

            title = savedInstanceState.getString(STATE_TITLE);
            ArrayList<Hidangan> stateList = savedInstanceState.getParcelableArrayList(STATE_LIST);
            int stateMode = savedInstanceState.getInt(STATE_MODE);


            setActionBarTitle(title);
            list.addAll(stateList);
            setMode(stateMode);
        }

    }

    private void showSelectedHero(Hidangan hidangan) {
        Toast.makeText(this, "Kamu memilih " + hidangan.getName(), Toast.LENGTH_SHORT).show();
    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListHidanganAdapter listHidanganAdapter = new ListHidanganAdapter(this);
        listHidanganAdapter.setListHidangans(list);
        rvCategory.setAdapter(listHidanganAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            private static final String EXTRA_NAME ="Mie Ayam Pangsit";

            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
      //          showSelectedHero(list.get(position));
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_NAME, "Mie Ayam Pangsit");
                //kirimkan parameter
//                a.putExtra("Remarks", getremarks[position]);
//                a.putExtra("photo",photo[position]);
                startActivity(intent);
            }
        });
    }

    private void showRecyclerGrid() {
        rvCategory.setLayoutManager(new GridLayoutManager(this, 2));
        GridHidanganAdapter gridHidanganAdapter = new GridHidanganAdapter(this);
        gridHidanganAdapter.setListHidangans(list);
        rvCategory.setAdapter(gridHidanganAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedHero(list.get(position));
            }
        });
    }

    private void showRecyclerCardView() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        CardViewHidanganAdapter cardViewHidanganAdapter = new CardViewHidanganAdapter(this);
        cardViewHidanganAdapter.setListHidangans(list);
        rvCategory.setAdapter(cardViewHidanganAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        setMode(item.getItemId());

        return super.onOptionsItemSelected(item);
    }


    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.action_list:
                title = "Mode List";
                showRecyclerList();
                break;

            case R.id.action_grid:
                title = "Mode Grid";
                showRecyclerGrid();
                break;

            case R.id.action_cardview:
                title = "Mode CardView";
                showRecyclerCardView();
                break;
        }

        mode = selectedMode;
        setActionBarTitle(title);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, title);
        outState.putParcelableArrayList(STATE_LIST, list);
        outState.putInt(STATE_MODE, mode);
    }
}
