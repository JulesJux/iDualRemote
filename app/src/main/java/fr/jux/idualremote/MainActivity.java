package fr.jux.idualremote;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.hardware.ConsumerIrManager;
import android.os.Bundle;
import android.view.HapticFeedbackConstants;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {
    final int[] on = {8960, 4480, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 40320};
    final int[] off = {8960, 4480, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 40320};
    final int[] darker = {8960, 4480, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 40320};
    final int[] brighter = {8960, 4480, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 40320};
    final int[] red = {8960, 4480, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 40320};
    final int[] green = {8960, 4480, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 40320};
    final int[] blue = {8960, 4480, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 1680, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 560, 560, 1680, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 40320};
    final int[] yellow = {8960, 4480, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 40320};
    final int[] saturate = {8960, 4480, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 1680, 560, 560, 560, 1680, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 40320};
    final int[] desaturate = {8960, 4480, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 40320};
    final int[] candle = {8960, 4480, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 40320};
    final int[] mediate = {8960, 4480, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 40320};
    final int[] bulb = {8960, 4480, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 1680, 560, 1680, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 1680, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 40320};
    final int[] sun = {8960, 4480, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 1680, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 560, 560, 1680, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 40320};
    final int[] learn = {8960, 4480, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 40320};
    final int[] ice = {8960, 4480, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 40320};
    final int[] child = {8960, 4480, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 560, 560, 1680, 560, 1680, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 40320};
    final int[] sleep = {8960, 4480, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 40320};
    final int[] sunrise = {8960, 4480, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 40320};
    final int[] sunset = {8960, 4480, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 40320};
    final int[] rotate = {8960, 4480, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 40320};
    final int[] party = {8960, 4480, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 40320};
    final int[] forest = {8960, 4480, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 560, 560, 1680, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 560, 560, 1680, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 40320};
    final int[] water = {8960, 4480, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 40320};
    final int[] fire = {8960, 4480, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 1680, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 40320};
    final int[] love = {8960, 4480, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 560, 560, 1680, 560, 1680, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 560, 1680, 560, 560, 560, 560, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 1680, 560, 40320};
    final float x2 = (float) Resources.getSystem().getDisplayMetrics().widthPixels / 901;
    final float y2 = (float) Resources.getSystem().getDisplayMetrics().heightPixels / 1945;
    ConsumerIrManager ir;
    ImageView remote;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ir = (ConsumerIrManager) getSystemService(Context.CONSUMER_IR_SERVICE);
        remote = findViewById(R.id.remote);
        remote.setOnTouchListener((v1, event) -> {
            v1.setHapticFeedbackEnabled(true);
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                float x = event.getX();
                float y = event.getY();
                if (ir.hasIrEmitter()) {
                    if (isTouched(x, y, 633, 114, 780, 260)) {
                        ir.transmit(38000, on);
                        v1.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                    }
                    if (isTouched(x, y, 633, 291, 780, 435)) {
                        ir.transmit(38000, off);
                        v1.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                    }
                    if (isTouched(x, y, 110, 291, 256, 435)) {
                        ir.transmit(38000, darker);
                        v1.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                    }
                    if (isTouched(x, y, 458, 291, 605, 435)) {
                        ir.transmit(38000, brighter);
                        v1.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                    }
                    if (isTouched(x, y, 375, 1166, 515, 1307)) {
                        ir.transmit(38000, red);
                        v1.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                    }
                    if (isTouched(x, y, 375, 1690, 515, 1831)) {
                        ir.transmit(38000, green);
                        v1.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                    }
                    if (isTouched(x, y, 110, 1425, 256, 1567)) {
                        ir.transmit(38000, blue);
                        v1.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                    }
                    if (isTouched(x, y, 636, 1425, 777, 1567)) {
                        ir.transmit(38000, yellow);
                        v1.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                    }
                    if (isTouched(x, y, 290, 1425, 435, 1567)) {
                        ir.transmit(38000, saturate);
                        v1.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                    }
                    if (isTouched(x, y, 450, 1425, 600, 1567)) {
                        ir.transmit(38000, desaturate);
                        v1.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                    }
                    if (isTouched(x, y, 110, 465, 256, 614)) {
                        ir.transmit(38000, candle);
                        v1.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                    }
                    if (isTouched(x, y, 635, 645, 780, 790)) {
                        ir.transmit(38000, mediate);
                        v1.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                    }
                    if (isTouched(x, y, 283, 465, 431, 614)) {
                        ir.transmit(38000, bulb);
                        v1.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                    }
                    if (isTouched(x, y, 458, 465, 604, 614)) {
                        ir.transmit(38000, sun);
                        v1.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                    }
                    if (isTouched(x, y, 460, 645, 605, 789)) {
                        ir.transmit(38000, learn);
                        v1.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                    }
                    if (isTouched(x, y, 633, 465, 778, 614)) {
                        ir.transmit(38000, ice);
                        v1.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                    }
                    if (isTouched(x, y, 110, 645, 256, 790)) {
                        ir.transmit(38000, child);
                        v1.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                    }
                    if (isTouched(x, y, 285, 645, 431, 790)) {
                        ir.transmit(38000, sleep);
                        v1.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                    }
                    if (isTouched(x, y, 110, 823, 256, 967)) {
                        ir.transmit(38000, sunrise);
                        v1.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                    }
                    if (isTouched(x, y, 634, 831, 779, 967)) {
                        ir.transmit(38000, sunset);
                        v1.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                    }
                    if (isTouched(x, y, 284, 823, 431, 967)) {
                        ir.transmit(38000, rotate);
                        v1.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                    }
                    if (isTouched(x, y, 460, 823, 606, 967)) {
                        ir.transmit(38000, party);
                        v1.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                    }
                    if (isTouched(x, y, 110, 1000, 256, 1141)) {
                        ir.transmit(38000, forest);
                        v1.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                    }
                    if (isTouched(x, y, 283, 1000, 431, 1141)) {
                        ir.transmit(38000, water);
                        v1.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                    }
                    if (isTouched(x, y, 460, 1000, 605, 1141)) {
                        ir.transmit(38000, fire);
                        v1.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                    }
                    if (isTouched(x, y, 634, 1000, 780, 1141)) {
                        ir.transmit(38000, love);
                        v1.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS, HapticFeedbackConstants.FLAG_IGNORE_GLOBAL_SETTING);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "IR emitter not found", Toast.LENGTH_LONG).show();
                }
            }
            return true;
        });
    }

    private boolean isTouched(float x, float y, float zoneLeft, float zoneTop, float zoneRight, float zoneBottom) {
        return x >= zoneLeft * x2 && x <= zoneRight * x2 && y >= zoneTop * y2 && y <= zoneBottom * y2;
    }
}