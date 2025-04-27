package com.HP.Verification;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.CycleInterpolator;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.app.Activity;
import android.content.res.ColorStateList;
import android.graphics.drawable.RippleDrawable;

import java.util.Timer;
import java.util.TimerTask;


public class PinVerificationView extends LinearLayout {
	
	private Timer _timer = new Timer();
	
	private String str_text1 = "";
	private String fontName = "";
	private String typeace = "";
	private boolean isVisible = false;
	
	private LinearLayout main;
	private LinearLayout toolbar;
	private LinearLayout keypad;
	private LinearLayout layer_2;
	private TextView title_txt;
	private TextView passcode_txt;
	private LinearLayout linearLayout;
	private LinearLayout indicator;
	private GridLayout keypad_2;
	private LinearLayout pin1;
	private LinearLayout pin2;
	private LinearLayout pin3;
	private LinearLayout pin4;
	private TextView num_1;
	private TextView num_2;
	private TextView num_3;
	private TextView num_4;
	private TextView num_5;
	private TextView num_6;
	private TextView num_7;
	private TextView num_8;
	private TextView num_9;
	private LinearLayout reset_lin;
	private TextView num_0;
	private LinearLayout backspace_lin;
	private ImageView reset_img;
	private ImageView backspace_img;
	
	private ObjectAnimator an = new ObjectAnimator();
	private TimerTask delay;
    private Context mContext;
	
	public PinVerificationView(Context context) {
		super(context);
        mContext = context;
		init(context);
	}
	
	public PinVerificationView(Context context, AttributeSet attrs) {
		super(context, attrs);
        mContext = context;
		init(context);
	}
	
	private void init(Context context) {
		inflate(context, R.layout.hosted_pin_ui, this);
		initialize();
		initializeLogic();
	}
	
	private void initialize() {
		main = findViewById(R.id.main);
		toolbar = findViewById(R.id.toolbar);
		keypad = findViewById(R.id.keypad);
		layer_2 = findViewById(R.id.layer_2);
		title_txt = findViewById(R.id.title_txt);
		passcode_txt = findViewById(R.id.passcode_txt);
		linearLayout = findViewById(R.id.linearLayout);
		indicator = findViewById(R.id.indicator);
		keypad_2 = findViewById(R.id.keypad_2);
		pin1 = findViewById(R.id.pin1);
		pin2 = findViewById(R.id.pin2);
		pin3 = findViewById(R.id.pin3);
		pin4 = findViewById(R.id.pin4);
		num_1 = findViewById(R.id.num_1);
		num_2 = findViewById(R.id.num_2);
		num_3 = findViewById(R.id.num_3);
		num_4 = findViewById(R.id.num_4);
		num_5 = findViewById(R.id.num_5);
		num_6 = findViewById(R.id.num_6);
		num_7 = findViewById(R.id.num_7);
		num_8 = findViewById(R.id.num_8);
		num_9 = findViewById(R.id.num_9);
		reset_lin = findViewById(R.id.reset_lin);
		num_0 = findViewById(R.id.num_0);
		backspace_lin = findViewById(R.id.backspace_lin);
		reset_img = findViewById(R.id.reset_img);
		backspace_img = findViewById(R.id.backspace_img);
		
		num_1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Pass(num_1.getText().toString(), num_1.getText().toString());
			}
		});
		
		num_2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Pass(num_2.getText().toString(), num_2.getText().toString());
			}
		});
		
		num_3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Pass(num_3.getText().toString(), num_3.getText().toString());
			}
		});
		
		num_4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Pass(num_4.getText().toString(), num_4.getText().toString());
			}
		});
		
		num_5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Pass(num_5.getText().toString(), num_5.getText().toString());
			}
		});
		
		num_6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Pass(num_6.getText().toString(), num_6.getText().toString());
			}
		});
		
		num_7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Pass(num_7.getText().toString(), num_7.getText().toString());
			}
		});
		
		num_8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Pass(num_8.getText().toString(), num_8.getText().toString());
			}
		});
		
		num_9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Pass(num_9.getText().toString(), num_9.getText().toString());
			}
		});
		
		reset_lin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				passcode_txt.setText("Enter New Passcode");
				reset_lin.setVisibility(View.INVISIBLE);
				str_text1 = "";
				
			}
		});
		
		num_0.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_Pass(num_0.getText().toString(), num_0.getText().toString());
			}
		});
		
		backspace_lin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (str_text1.length() == 1) {
					str_text1 = "";
					pin1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)360, (int)2, 0xFF3F51B5, Color.TRANSPARENT));
				}
				if (str_text1.length() == 2) {
					str_text1 = str_text1.substring((int)(0), (int)(1));
					pin2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)360, (int)2, 0xFF3F51B5, Color.TRANSPARENT));
				}
				if (str_text1.length() == 3) {
					str_text1 = str_text1.substring((int)(0), (int)(2));
					pin3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)360, (int)2, 0xFF3F51B5, Color.TRANSPARENT));
				}
				if (str_text1.length() == 4) {
					str_text1 = str_text1.substring((int)(0), (int)(3));
					pin4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)360, (int)2, 0xFF3F51B5, Color.TRANSPARENT));
				}
			}
		});
	}
	
	private void initializeLogic() {
		_UiDesign();
	}
	
	public void _UiDesign() {
		main.setBackgroundColor(0xFFFFFFFF);
		_rippleRoundStroke(num_1, "#E0E0E0", "#FFFFFF", 100, 0, "#FFFFFF");
		_rippleRoundStroke(num_2, "#E0E0E0", "#FFFFFF", 100, 0, "#FFFFFF");
		_rippleRoundStroke(num_3, "#E0E0E0", "#FFFFFF", 100, 0, "#FFFFFF");
		_rippleRoundStroke(num_4, "#E0E0E0", "#FFFFFF", 100, 0, "#FFFFFF");
		_rippleRoundStroke(num_5, "#E0E0E0", "#FFFFFF", 100, 0, "#FFFFFF");
		_rippleRoundStroke(num_6, "#E0E0E0", "#FFFFFF", 100, 0, "#FFFFFF");
		_rippleRoundStroke(num_7, "#E0E0E0", "#FFFFFF", 100, 0, "#FFFFFF");
		_rippleRoundStroke(num_8, "#E0E0E0", "#FFFFFF", 100, 0, "#FFFFFF");
		_rippleRoundStroke(num_9, "#E0E0E0", "#FFFFFF", 100, 0, "#FFFFFF");
		_rippleRoundStroke(num_0, "#E0E0E0", "#FFFFFF", 100, 0, "#FFFFFF");
		_rippleRoundStroke(backspace_lin, "#3F51B5", "#FFFFFF", 100, 0, "#FFFFFF");
		_rippleRoundStroke(reset_lin, "#3F51B5", "#FFFFFF", 100, 0, "#FFFFFF");
		indicator.setBackgroundColor(0xFFE0E0E0);
		num_1.setTextColor(0xFF000000);
		num_2.setTextColor(0xFF000000);
		num_3.setTextColor(0xFF000000);
		num_4.setTextColor(0xFF000000);
		num_5.setTextColor(0xFF000000);
		num_6.setTextColor(0xFF000000);
		num_7.setTextColor(0xFF000000);
		num_8.setTextColor(0xFF000000);
		num_9.setTextColor(0xFF000000);
		num_0.setTextColor(0xFF000000);
		pin1.setBackground(createStrokeCircleDrawable(0xFF3F51B5, 2));
		pin2.setBackground(createStrokeCircleDrawable(0xFF3F51B5, 2));
		pin3.setBackground(createStrokeCircleDrawable(0xFF3F51B5, 2));
		pin4.setBackground(createStrokeCircleDrawable(0xFF3F51B5, 2));
	}
	
	
	public void _rippleRoundStroke(final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public void _Pass(final String _txt, final String _txt2) {
		if (str_text1.length() == 0) {
			str_text1 = str_text1.concat(_txt);
			pin1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)360, 0xFF3F51B5));
		} else {
			if (str_text1.length() == 1) {
				str_text1 = str_text1.concat(_txt);
				pin2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)360, 0xFF3F51B5));
			} else {
				if (str_text1.length() == 2) {
					str_text1 = str_text1.concat(_txt);
					pin3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)360, 0xFF3F51B5));
				} else {
					if (str_text1.length() == 3) {
						str_text1 = str_text1.concat(_txt);
						pin4.setBackground(createCircleDrawable(0xFF3F51B5));
						delay = new TimerTask() {
							@Override
							public void run() {
								((Activity) mContext).runOnUiThread(new Runnable() {
									@Override
									public void run() {
										pin1.setBackground(createStrokeCircleDrawable(0xFF3F51B5, 2));
										pin2.setBackground(createStrokeCircleDrawable(0xFF3F51B5, 2));
										pin3.setBackground(createStrokeCircleDrawable(0xFF3F51B5, 2));
										pin4.setBackground(createStrokeCircleDrawable(0xFF3F51B5, 2));
										if (pinCompleteListener != null) {
											pinCompleteListener.onPinComplete(str_text1); 
										}
										str_text1 = "";
									}
								});
							}
						};
						_timer.schedule(delay, (int)(300));
					}
				}
			}
		}
	}
	
	
	public void _extra() {
	}
	
	public void shake() {
		ObjectAnimator animator = ObjectAnimator.ofFloat(this, "translationX", 0, 10, -10, 10, -10, 0);
		animator.setDuration(500);
		animator.setInterpolator(new CycleInterpolator(5));
		animator.start();
	}
	
	// 1. Create Interface
	public interface OnPinCompleteListener {
		void onPinComplete(String pin);
	}
	
	// 2. Create Variable
	private OnPinCompleteListener pinCompleteListener;
	
	// 3. Create Setter
	public void setOnPinCompleteListener(OnPinCompleteListener listener) {
		this.pinCompleteListener = listener;
		
	}
	
	private GradientDrawable createCircleDrawable(int color) {
		GradientDrawable drawable = new GradientDrawable();
		drawable.setCornerRadius(360);
		drawable.setColor(color);
		return drawable;
	}
	
	private GradientDrawable createStrokeCircleDrawable(int strokeColor, int strokeWidth) {
		GradientDrawable drawable = new GradientDrawable();
		drawable.setCornerRadius(360);
		drawable.setStroke(strokeWidth, strokeColor);
		drawable.setColor(Color.TRANSPARENT);
		return drawable;
		
	}
	
}
