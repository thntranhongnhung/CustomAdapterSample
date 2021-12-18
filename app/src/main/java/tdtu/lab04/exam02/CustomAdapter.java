package tdtu.lab04.exam02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends ArrayAdapter<String> {

    private Context context;
    private TextView itemListText;
    private Button itemButton;
    private List<String> listValues;


    public CustomAdapter(Context context, int resource, List<String> listValues) {
        super(context, resource,listValues);
        this.context = context;
        this.listValues = listValues;
    }

    /**
     * getView method is called for each item of ListView
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String currentValue = listValues.get(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_item_view, null);

        itemListText = (TextView)convertView.findViewById(R.id.my_text_view);
        itemListText.setText(currentValue);



        itemButton = (Button)convertView.findViewById(R.id.button);
        //To lazy to implement interface
        itemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listValues.remove(listValues.get(position));
                notifyDataSetChanged();



            }
        });

        return convertView;
    }
}
