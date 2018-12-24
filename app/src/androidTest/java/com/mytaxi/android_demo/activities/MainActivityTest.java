package com.mytaxi.android_demo.activities;

import android.support.test.espresso.IdlingRegistry;
import android.support.test.rule.ActivityTestRule;
import android.util.Log;

import com.mytaxi.android_demo.PageObjects.InDriverProfilePage;
import com.mytaxi.android_demo.PageObjects.InLoginPage;
import com.mytaxi.android_demo.PageObjects.InSearchDriverPage;
import com.mytaxi.android_demo.utils.EspressoIdlingResource;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static com.mytaxi.android_demo.Utilities.DataConstants.sDriverFullName;
import static com.mytaxi.android_demo.Utilities.DataConstants.sDriverShortName;
import static com.mytaxi.android_demo.Utilities.DataConstants.sPassword;
import static com.mytaxi.android_demo.Utilities.DataConstants.sUserName;

@SuppressWarnings("ALL")
public class MainActivityTest
{
    @Rule
    public ActivityTestRule<MainActivity> mainActivityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Before
    public void setUp(){ IdlingRegistry.getInstance().register(EspressoIdlingResource.getIdlingResource());}

    @Test
    public void Task_TestAutomation()
    {
        try{
            InLoginPage.UserLogsInWith(sUserName,sPassword);
            InSearchDriverPage.SearchandPickDriver(sDriverShortName,sDriverFullName,mainActivityActivityTestRule);
            InDriverProfilePage.CallDriver(sDriverFullName); }
        catch (Exception e){
            Log.d("Task_TestAutomation","Exception Thrown as :"+e.toString());}
    }

    @After
    public void tearDown(){
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getIdlingResource()); }

}