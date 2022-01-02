package kavs.myappcompany.onlinelibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import kavs.myappcompany.onlinelibrary.DRVInterface.LoadMore;

public class Dashboard extends AppCompatActivity {

    private RecyclerView recyclerView;
    private  StaticRvAdapter staticRvAdapter;


    List<DynamicRVModel> items = new ArrayList();
    DynamicRVAdapter dynamicRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ArrayList<StaticRvModel> item = new ArrayList<>();
        item.add(new StaticRvModel(R.drawable.comic, "comic"));
        item.add(new StaticRvModel(R.drawable.horror, "horror"));
        item.add(new StaticRvModel(R.drawable.education, "education"));
        item.add(new StaticRvModel(R.drawable.comedy, "comedy"));
        item.add(new StaticRvModel(R.drawable.romantic, "romantic"));

        recyclerView = findViewById(R.id.rv_1);
        staticRvAdapter = new StaticRvAdapter(item);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(staticRvAdapter);

        items.add(new DynamicRVModel("Horror"));
        items.add(new DynamicRVModel("Horror"));
        items.add(new DynamicRVModel("Horror"));
        items.add(new DynamicRVModel("Horror"));
        items.add(new DynamicRVModel("Horror"));
        items.add(new DynamicRVModel("Horror"));
        items.add(new DynamicRVModel("Horror"));
        items.add(new DynamicRVModel("Horror"));
        items.add(new DynamicRVModel("Horror"));
        items.add(new DynamicRVModel("Horror"));
        items.add(new DynamicRVModel("Horror"));
        items.add(new DynamicRVModel("Horror"));
        items.add(new DynamicRVModel("Horror"));
        items.add(new DynamicRVModel("Horror"));
        items.add(new DynamicRVModel("Horror"));
        items.add(new DynamicRVModel("Horror"));
        items.add(new DynamicRVModel("Horror"));
        items.add(new DynamicRVModel("Horror"));

        RecyclerView drv = findViewById(R.id.rv_2);
        drv. setLayoutManager(new LinearLayoutManager(this));
        dynamicRVAdapter = new DynamicRVAdapter(drv, this,items);
        drv.setAdapter(dynamicRVAdapter);

        dynamicRVAdapter.setLoadMore(new LoadMore() {
            @Override
            public void onLoadMore() {
                if(items.size() <= 10) {
                    item.add(null);
                    dynamicRVAdapter.notifyItemInserted(item.size()-1);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            items.remove(items.size()-1);
                            dynamicRVAdapter.notifyItemRemoved(items.size());

                            int index = items.size();
                            int end= index+10;
                            for(int i=index; i<end; i++){
                                String name = UUID.randomUUID().toString();
                                DynamicRVModel item = new DynamicRVModel(name);
                                items.add(item);
                            }
                            dynamicRVAdapter.notifyDataSetChanged();
                            dynamicRVAdapter.setLoad();
                        }
                    },  4000);

                }
                else
                    Toast.makeText(Dashboard.this, "Data Completed", Toast.LENGTH_SHORT).show();
            }
        });
    }
}