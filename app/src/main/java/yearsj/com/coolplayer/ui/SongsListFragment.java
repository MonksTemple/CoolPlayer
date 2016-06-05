package yearsj.com.coolplayer.ui;

import  android.support.v4.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.view.Window;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import yearsj.com.coolplayer.adapter.SortAdapter;
import yearsj.com.coolplayer.R;
import yearsj.com.coolplayer.model.SortModel;
import yearsj.com.coolplayer.ui.view.CharacterSideBarView;
import yearsj.com.coolplayer.util.CharacterParser;
import yearsj.com.coolplayer.util.PinyinComparator;

/**
 * Created by bing on 2016/6/2.
 */
public class SongsListFragment extends Fragment {
    /**
     * 事件列表
     **/
    private ListView list;
    private View view;
    LayoutInflater inflater;

 //   private SortAdapter adapter;
//    private CharacterSideBarView sideBar;
//    private TextView dialog;

//    private PinyinComparator pinyinComparator;
//    private CharacterParser characterParser;
//    private List<SortModel> SourceDateList;
//    private int listViewHeight;

    final String TITLE = "title";
    final String INFO = "info";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        Log.v("yearsj", "fragment1-->onCreate()");

        LayoutInflater inflater = getActivity().getLayoutInflater();
        this.inflater = inflater;
        view = inflater.inflate(R.layout.fragment_songs, (ViewGroup)getActivity().findViewById(R.id.viewpager), true);
        initial();
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup p = (ViewGroup) view.getParent();
        if (p != null) {
            p.removeAllViewsInLayout();
        }
        return view;
    }

    private void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }
        int totalHeight = 0;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem= listAdapter.getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
       // listViewHeight=getActivity().getWindowManager().getDefaultDisplay().getHeight()/2;
      //  listViewHeight=totalHeight;
    }

    void initial() {
        list = (ListView) view.findViewById(R.id.songListView);
//        sideBar = (CharacterSideBarView) view.findViewById(R.id.sidebars);
//        dialog = (TextView)view.findViewById(R.id.adialog);
//        characterParser = CharacterParser.getInstance();
//        pinyinComparator = new PinyinComparator();

        loadData();
        setListViewHeightBasedOnChildren(list);
        setOnListListener();
//        sideBar.setTextView(dialog, listViewHeight);
//        sideBar.setOnTouchingLetterChangedListener(new CharacterSideBarView.OnTouchingLetterChangedListener() {
//
//            @Override
//            public void onTouchingLetterChanged(String s) {
//                int position = adapter.getPositionForSection(s.charAt(0));
//                if (position != -1) {
//                    list.setSelection(position);
//                }
//
//            }
//        });
    }

    void loadData() {
        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map;
        for (int i = 0; i < 5; i++) {
            map = new HashMap<String, String>();
            map.put(TITLE, "陈奕迅");
            map.put(INFO, "好久不见·认了吧");
            mylist.add(map);
        }

        SimpleAdapter songsAdapter = new SimpleAdapter(view.getContext(),
                mylist,
                R.layout.two_item_list,


                new String[]{ TITLE, INFO},


                new int[]{R.id.titleView, R.id.infoView});

       list.setAdapter(songsAdapter);

    }


    /**
     * 列表子项点击事件响应
     */
    private void setOnListListener() {
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO 自动生成的方法存根

//                System.out.println(id);
            }

        });

    }
}
