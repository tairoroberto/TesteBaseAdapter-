package br.com.panicobass.testelistactivity;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class CarroAdapter extends BaseAdapter {
	Context context;
	ArrayList<Carro> list;

	public CarroAdapter(Context context, ArrayList<Carro> list) {
		this.context = context;
		this.list = list;
	}

	@Override
	public int getCount() {
		// Retorna o tamanho da lista
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// retorna a posição da lista
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// Retorna o id da posição
		return position;
	}

	/************************************************************************************
	 * Criação da classe estática ViewHolder que será uma ponte para a lista *
	 * Essa classe é usada para dar mehor desempenho a lista *
	 *************************** ********************************************************/

	static class ViewHolder {
		TextView modeloCarro;
		TextView marcaCarro;
		ImageView img;
	}

	// retorna o layout da lista
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// declaramos uma instancia para o layout
		ViewHolder layout = new ViewHolder();
		// instacia do objeto carro
		Carro carro = list.get(position);

		if (convertView == null) {
			// infla o layput para ser usado
			LayoutInflater inflater = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.layout_lista, null);

			// passa o nome do modelo do carro para o layout inflado
			layout.modeloCarro = (TextView) convertView
					.findViewById(R.id.txtModelo);

			// passa o nome do modelo do carro para o layout inflado
			layout.img = (ImageView) convertView.findViewById(R.id.imgView);
			layout.img.setImageResource(carro.getCarroImagem(position));

			// passa o nome da marca carro para o layout inflado
			layout.marcaCarro = (TextView) convertView
					.findViewById(R.id.txtMarca);

			convertView.setTag(layout);
		} else {
			final ViewHolder holder = (ViewHolder) convertView.getTag();
			holder.modeloCarro.setText(carro.getModelo());
			holder.img.setImageResource(carro.getCarroImagem(position));
			holder.marcaCarro.setText(carro.getMarca());
			holder.marcaCarro.setTextColor(Color.BLUE);
		}

		return convertView;
	}

}
