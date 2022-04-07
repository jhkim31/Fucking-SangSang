// Generated by view binder compiler. Do not edit!
package com.example.madpt.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.madpt.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentGoalSetPageBinding implements ViewBinding {
  @NonNull
  private final FrameLayout rootView;

  @NonNull
  public final EditText goalEatkcal;

  @NonNull
  public final EditText goalMovekcal;

  @NonNull
  public final Button goalSaveButton;

  @NonNull
  public final EditText goalWeight;

  @NonNull
  public final TextView mainPageToday;

  private FragmentGoalSetPageBinding(@NonNull FrameLayout rootView, @NonNull EditText goalEatkcal,
      @NonNull EditText goalMovekcal, @NonNull Button goalSaveButton, @NonNull EditText goalWeight,
      @NonNull TextView mainPageToday) {
    this.rootView = rootView;
    this.goalEatkcal = goalEatkcal;
    this.goalMovekcal = goalMovekcal;
    this.goalSaveButton = goalSaveButton;
    this.goalWeight = goalWeight;
    this.mainPageToday = mainPageToday;
  }

  @Override
  @NonNull
  public FrameLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentGoalSetPageBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentGoalSetPageBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_goal_set_page, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentGoalSetPageBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.goal_eatkcal;
      EditText goalEatkcal = ViewBindings.findChildViewById(rootView, id);
      if (goalEatkcal == null) {
        break missingId;
      }

      id = R.id.goal_movekcal;
      EditText goalMovekcal = ViewBindings.findChildViewById(rootView, id);
      if (goalMovekcal == null) {
        break missingId;
      }

      id = R.id.goal_save_button;
      Button goalSaveButton = ViewBindings.findChildViewById(rootView, id);
      if (goalSaveButton == null) {
        break missingId;
      }

      id = R.id.goal_weight;
      EditText goalWeight = ViewBindings.findChildViewById(rootView, id);
      if (goalWeight == null) {
        break missingId;
      }

      id = R.id.mainPageToday;
      TextView mainPageToday = ViewBindings.findChildViewById(rootView, id);
      if (mainPageToday == null) {
        break missingId;
      }

      return new FragmentGoalSetPageBinding((FrameLayout) rootView, goalEatkcal, goalMovekcal,
          goalSaveButton, goalWeight, mainPageToday);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
