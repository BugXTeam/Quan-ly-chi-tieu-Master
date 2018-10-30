package moneyapp.com.quanlytienbac;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.List;
import java.util.Locale;

public class ItemAdapter extends BaseAdapter {
    private AddActivity context1;
    private MainActivity context;
    private int layout;
    private List<Item> list;

    public ItemAdapter(MainActivity context, int layout, List<Item> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public class viewHolder {
        TextView txt1, txt2, txt3;
        ImageButton imgbt1, imgbt2;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final viewHolder holder;
        if (convertView == null) {
            holder = new viewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);
            holder.txt1 = (TextView) convertView.findViewById(R.id.textViewListTen);
            holder.txt2 = (TextView) convertView.findViewById(R.id.textViewListNgay);
            holder.txt3 = (TextView) convertView.findViewById(R.id.textViewListTien);
            holder.imgbt1 = (ImageButton) convertView.findViewById(R.id.imageButton);
            holder.imgbt2 = (ImageButton) convertView.findViewById(R.id.imageButton2);
            convertView.setTag(holder);
        } else {
            holder = (viewHolder) convertView.getTag();
        }
        NumberFormat format = new DecimalFormat("#,##0");

        final Item item = list.get(position);
        double tmpGia=ParseDouble(item.getTien());
        holder.txt1.setText(item.getTen());
        holder.txt2.setText(item.getNgay());
        holder.txt3.setText(format.format(tmpGia)+" VNĐ");


        holder.imgbt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.dialog(item.getId(), item.getTen(), item.getNgay(), item.getTien());
            }
        });

        holder.imgbt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.dialogXoa(item.getTen(),item.getId());

            }
        });


        return convertView;
    }
    double ParseDouble(String str) {
        if (str != null && str.length() > 0) {
            try {
                return Double.parseDouble(str);
            } catch(Exception e) {
                return -1;
            }
        }
        else return 0;
    }

}
