// Generated by view binder compiler. Do not edit!
package com.example.madpt.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.madpt.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentExcerciseBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnBreakTime;

  @NonNull
  public final Button btnRoutinLoading;

  @NonNull
  public final Button btnRoutineStore;

  @NonNull
  public final RecyclerView recyclerView;

  @NonNull
  public final RecyclerView trainListRecyclerView;

  private FragmentExcerciseBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnBreakTime,
      @NonNull Button btnRoutinLoading, @NonNull Button btnRoutineStore,
      @NonNull RecyclerView recyclerView, @NonNull RecyclerView trainListRecyclerView) {
    this.rootView = rootView;
    this.btnBreakTime = btnBreakTime;
    this.btnRoutinLoading = btnRoutinLoading;
    this.btnRoutineStore = btnRoutineStore;
    this.recyclerView = recyclerView;
    this.trainListRecyclerView = trainListRecyclerView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentExcerciseBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentExcerciseBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_excercise, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentExcerciseBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btn_breakTime;
      Button btnBreakTime = ViewBindings.findChildViewById(rootView, id);
      if (btnBreakTime == null) {
        break missingId;
      }

      id = R.id.btn_routinLoading;
      Button btnRoutinLoading = ViewBindings.findChildViewById(rootView, id);
      if (btnRoutinLoading == null) {
        break missingId;
      }

      id = R.id.btn_routineStore;
      Button btnRoutineStore = ViewBindings.findChildViewById(rootView, id);
      if (btnRoutineStore == null) {
        break missingId;
      }

      id = R.id.recycler_view;
      RecyclerView recyclerView = ViewBindings.findChildViewById(rootView, id);
      if (recyclerView == null) {
        break missingId;
      }

      id = R.id.trainListRecyclerView;
      RecyclerView trainListRecyclerView = ViewBindings.findChildViewById(rootView, id);
      if (trainListRecyclerView == null) {
        break missingId;
      }

      return new FragmentExcerciseBinding((ConstraintLayout) rootView, btnBreakTime,
          btnRoutinLoading, btnRoutineStore, recyclerView, trainListRecyclerView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
