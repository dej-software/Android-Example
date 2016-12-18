package com.jikexueyuan.learnrecyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by dej on 2016/10/4.
 */
class MyAdapter extends RecyclerView.Adapter {

    class ViewHolder extends RecyclerView.ViewHolder {

        private View root;
        private TextView tvTitle, tvContent;

        public ViewHolder(View root) {
            super(root);

            tvTitle = (TextView) root.findViewById(R.id.tvTitle);
            tvContent = (TextView) root.findViewById(R.id.tvContent);
        }

        public TextView getTvTitle() {
            return tvTitle;
        }

        public TextView getTvContent() {
            return tvContent;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_cell, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder vh = (ViewHolder) holder;

        CellData cd = data[position];
        vh.getTvTitle().setText(cd.getTitle());
        vh.getTvContent().setText(cd.getContent());
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    //    private String[] data = new String[]{"Hello", "Android", "DEJ"};
    private CellData[] data = new CellData[]{
            new CellData("极客学院", "IT职业教育"),
            new CellData("新闻", "这个新闻真不错"),
            new CellData("极客学院", "IT职业教育"),
            new CellData("新闻", "这个新闻真不错"),
            new CellData("极客学院", "IT职业教育"),
            new CellData("新闻", "这个新闻真不错"),
            new CellData("极客学院", "IT职业教育"),
            new CellData("新闻", "这个新闻真不错"),
            new CellData("极客学院", "IT职业教育"),
            new CellData("新闻", "这个新闻真不错"),
            new CellData("极客学院", "IT职业教育"),
            new CellData("新闻", "这个新闻真不错"),
            new CellData("极客学院", "IT职业教育"),
            new CellData("新闻", "这个新闻真不错"),
            new CellData("极客学院", "IT职业教育"),
            new CellData("新闻", "这个新闻真不错"),
            new CellData("极客学院", "IT职业教育"),
            new CellData("新闻", "这个新闻真不错"),
            new CellData("极客学院", "IT职业教育"),
            new CellData("新闻", "这个新闻真不错"),
            new CellData("极客学院", "IT职业教育"),
            new CellData("新闻", "这个新闻真不错"),
            new CellData("极客学院", "IT职业教育"),
            new CellData("新闻", "这个新闻真不错"),
            new CellData("极客学院", "IT职业教育"),
            new CellData("新闻", "这个新闻真不错"),
            new CellData("极客学院", "IT职业教育"),
            new CellData("新闻", "这个新闻真不错"),
            new CellData("极客学院", "IT职业教育"),
            new CellData("新闻", "这个新闻真不错"),
            new CellData("极客学院", "IT职业教育"),
            new CellData("新闻", "这个新闻真不错"),
            new CellData("极客学院", "IT职业教育"),
            new CellData("新闻", "这个新闻真不错"),
            new CellData("极客学院", "IT职业教育"),
            new CellData("新闻", "这个新闻真不错")};
}
