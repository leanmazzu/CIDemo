package com.globallogic.cidemo.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.globallogic.cidemo.R;
import com.globallogic.cidemo.activities.MainActivity;
import com.robotium.solo.Solo;

/**
 * 
 * @author leandro.mazzuquini
 *
 */
public class MainActivityTest extends ActivityInstrumentationTestCase2<MainActivity> {

	private Solo solo;

	public MainActivityTest() {
		super(MainActivity.class);
	}

	@Override
	public void setUp() throws Exception {
		// setUp() is run before a test case is started.
		// This is where the solo object is created.
		solo = new Solo(getInstrumentation(), getActivity());
		solo.clearEditText((EditText) solo.getView(R.id.value1));
		solo.clearEditText((EditText) solo.getView(R.id.value2));
	}

	@Override
	public void tearDown() throws Exception {
		// tearDown() is run after a test case has finished.
		// finishOpenedActivities() will finish all the activities that have
		// been opened during the test execution.
		solo.finishOpenedActivities();
	}

	public void testAddEmpty() {
		solo.unlockScreen();
		
		//Test both empty
		solo.clickOnView(solo.getView(R.id.button_add));
		assertTrue(solo.waitForText("Debes ingresar ambos operandos"));

		//Test value1 empty
		solo.typeText(0, "2");
		solo.clearEditText(1);
		solo.clickOnView(solo.getView(R.id.button_add));
		assertTrue(solo.waitForText("Debes ingresar ambos operandos"));

		//Test value2 empty
		solo.clearEditText(0);
		solo.typeText(1, "4");
		solo.clickOnView(solo.getView(R.id.button_add));
		assertTrue(solo.waitForText("Debes ingresar ambos operandos"));
	}
	
	public void testMultEmpty() {
		solo.unlockScreen();
		
		//Test both empty
		solo.clickOnView(solo.getView(R.id.button_mult));
		assertTrue(solo.waitForText("Debes ingresar ambos operandos"));

		//Test value1 empty
		solo.typeText(0, "2");
		solo.clearEditText(1);
		solo.clickOnView(solo.getView(R.id.button_mult));
		assertTrue(solo.waitForText("Debes ingresar ambos operandos"));

		//Test value2 empty
		solo.clearEditText(0);
		solo.typeText(1, "4");
		solo.clickOnView(solo.getView(R.id.button_mult));
		assertTrue(solo.waitForText("Debes ingresar ambos operandos"));
	}

	public void testAdd() throws Exception {
		// Unlock the lock screen
		solo.unlockScreen();
		solo.typeText(0, "2");
		solo.typeText(1, "4");

		solo.clickOnView(solo.getView(R.id.button_add));

		// Check the "+" operator is displayed
		assertTrue(solo.searchText("+", 2));
		// Check the result is displayed and correct
		assertTrue(solo.searchText("6"));
	}

	public void testMult() throws Exception {
		// Unlock the lock screen
		solo.unlockScreen();
		solo.enterText((EditText) solo.getView(R.id.value1), "2");
		solo.enterText((EditText) solo.getView(R.id.value2), "4");

		solo.clickOnView(solo.getView(R.id.button_mult));

		// Check the "x" operator is displayed
		assertTrue(solo.searchText("x", 2));
		// Check the result is displayed and correct
		assertTrue(solo.searchText("8"));
	}
	
	

}