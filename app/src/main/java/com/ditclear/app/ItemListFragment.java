package com.ditclear.app;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ditclear.app.databinding.ItemListBinding;
import com.ditclear.app.dummy.DummyContent;
import com.ditclear.app.recyleradapter.BaseViewAdapter;
import com.ditclear.app.recyleradapter.BindingViewHolder;
import com.ditclear.app.recyleradapter.MultiTypeAdapter;
import com.ditclear.app.recyleradapter.SingleTypeAdapter;

public class ItemListFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_item_list,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
    }

    protected void initView(View view) {

        mContext=getActivity();
        View recyclerView = view.findViewById(R.id.item_list);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);
    }
    Context mContext;
    MultiTypeAdapter mMultiTypeAdapter;
    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        mMultiTypeAdapter=new MultiTypeAdapter(mContext);
        mMultiTypeAdapter.addViewTypeToLayoutMap(ItemType.header,R.layout.title);
        mMultiTypeAdapter.addViewTypeToLayoutMap(ItemType.content,R.layout.item_list);
        mMultiTypeAdapter.addViewTypeToLayoutMap(ItemType.content1,R.layout.item_price);
        recyclerView.setAdapter(mMultiTypeAdapter);
        mMultiTypeAdapter.add(null,ItemType.header);
        mMultiTypeAdapter.setDecorator(new AdapterDecorator());
    }

    public class AdapterDecorator implements BaseViewAdapter.Decorator {

        @Override
        public void decorator(BindingViewHolder holder, int position, int viewType) {
            // you may do something according to position or view type
            ViewDataBinding binding=holder.getBinding();
            if (binding instanceof ItemListBinding){
                SingleTypeAdapter<DummyContent.DummyItem> adapter=new SingleTypeAdapter<DummyContent.DummyItem>(mContext,R.layout.item_check);
                ((ItemListBinding) binding).itemList.setAdapter(adapter);
                adapter.set(DummyContent.ITEMS);
                binding.executePendingBindings();
            }
        }
    }


}
