package com.seventh.VoiceAssistant;

import java.lang.reflect.Field;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.ViewConfiguration;
import android.widget.ArrayAdapter;
import android.widget.SpinnerAdapter;

import com.seventh.VoiceAssistant.Fragment.FirstFragment;
import com.seventh.VoiceAssistant.Fragment.SecondFragment;
import com.seventh.VoiceAssistant.Fragment.ThirdFragment;


public class MainActivity extends Activity implements TabListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();
		getOverflowMenu();
	}
	/**
	 * 初始化组件
	 */
	private void initView(){
		ActionBar actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		//定义一个下拉列表数据适配器
		SpinnerAdapter mSpinnerAdapter = ArrayAdapter.createFromResource(this,R.array.action_list,
				android.R.layout.simple_spinner_dropdown_item);
		actionBar.setListNavigationCallbacks(mSpinnerAdapter, new ActionBar.OnNavigationListener() {
			@Override
			public boolean onNavigationItemSelected(int itemPosition, long itemId) {
				return true;
			}
		});
		Tab tab = actionBar.newTab().setText("第一项").setTabListener(this);
	    actionBar.addTab(tab);
	    tab = actionBar.newTab().setText("第二项").setTabListener(this);
	    actionBar.addTab(tab);
	    tab = actionBar.newTab().setText("第三项").setTabListener(this);
	    actionBar.addTab(tab);
	    
	}
	
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		// Tab选中时要执行的代码
		switch (tab.getPosition()) {
	    case 0:
	    	FirstFragment ff = new FirstFragment();
	        ft.add(android.R.id.content, ff);
	        break;
	    case 1:
	        SecondFragment sf = new SecondFragment();
	        ft.add(android.R.id.content, sf);
	        break;
	    case 2:
	        ThirdFragment tf = new ThirdFragment();
	        ft.add(android.R.id.content, tf);
	        break;
	    default:
	        break;
	    }
	}
	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		// Tab被选中后用户再次选中该Tab所执行的代码，通常不做任何事情
	}
	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		// TODO Auto-generated method stub
		// Tab离开选中状态时执行的代码
	}
	/**
	 * 三点菜单
	 */
	private void getOverflowMenu() {
	     try {
	        ViewConfiguration config = ViewConfiguration.get(this);
	        Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
	        if(menuKeyField != null) {
	            menuKeyField.setAccessible(true);
	            menuKeyField.setBoolean(config, false);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
}
