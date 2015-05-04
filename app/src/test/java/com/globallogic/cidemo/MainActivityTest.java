package com.globallogic.cidemo;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowHandler;
import org.robolectric.shadows.ShadowToast;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.globallogic.cidemo.activities.MainActivity;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class MainActivityTest {

	private MainActivity activity;
	private EditText value1;
	private EditText value2;
	private TextView operator;
	private TextView result;

	@Before
	public void setUp() throws Exception {
		activity = Robolectric.buildActivity(MainActivity.class).create().get();
		value1 = (EditText) activity.findViewById(R.id.value1);
		value1.setText("");
		value2 = (EditText) activity.findViewById(R.id.value2);
		value2.setText("");
		operator = (TextView) activity.findViewById(R.id.operator);
		result = (TextView) activity.findViewById(R.id.result);
	}

	@Test
	public void testAddEmpty() {
		// Test both empty
		Button button = (Button) activity.findViewById(R.id.button_add);
		button.performClick();
		ShadowHandler.idleMainLooper();
		Assert.assertEquals("Debes ingresar ambos operandos",
				ShadowToast.getTextOfLatestToast());

		// Test value1 empty
		value1.setText("2");
		value2.setText("");
		button.performClick();
		ShadowHandler.idleMainLooper();
		Assert.assertEquals("Debes ingresar ambos operandos",
				ShadowToast.getTextOfLatestToast());

		// Test value2 empty
		value1.setText("");
		value2.setText("4");
		button.performClick();
		ShadowHandler.idleMainLooper();
		Assert.assertEquals("Debes ingresar ambos operandos",
				ShadowToast.getTextOfLatestToast());
	}

	@Test
	public void testMultEmpty() {
		// Test both empty
		Button button = (Button) activity.findViewById(R.id.button_mult);
		button.performClick();
		ShadowHandler.idleMainLooper();
		Assert.assertEquals("Debes ingresar ambos operandos",
				ShadowToast.getTextOfLatestToast());

		// Test value1 empty
		value1.setText("2");
		value2.setText("");
		button.performClick();
		ShadowHandler.idleMainLooper();
		Assert.assertEquals("Debes ingresar ambos operandos",
				ShadowToast.getTextOfLatestToast());

		// Test value2 empty
		value1.setText("");
		value2.setText("4");
		button.performClick();
		ShadowHandler.idleMainLooper();
		Assert.assertEquals("Debes ingresar ambos operandos",
				ShadowToast.getTextOfLatestToast());
	}

	@Test
	public void testAdd() throws Exception {
		value1.setText("2");
		value2.setText("4");
		
		CalcUtil mockCalcUtil = Mockito.mock(CalcUtil.class);
		Mockito.when(mockCalcUtil.add(2, 4)).thenReturn(6);

		Button button = (Button) activity.findViewById(R.id.button_add);
		button.performClick();

		// Check the "+" operator is displayed
		Assert.assertEquals("+", operator.getText());
		// Check the result is displayed and correct
		Assert.assertEquals("6", result.getText());
	}

	@Test
	public void testMult() throws Exception {
		value1.setText("2");
		value2.setText("4");

		CalcUtil mockCalcUtil = Mockito.mock(CalcUtil.class);
		Mockito.when(mockCalcUtil.mult(2, 4)).thenReturn(8);
		
		Button button = (Button) activity.findViewById(R.id.button_mult);
		button.performClick();

		// Check the "+" operator is displayed
		Assert.assertEquals("x", operator.getText());
		// Check the result is displayed and correct
		Assert.assertEquals("8", result.getText());
	}
}
