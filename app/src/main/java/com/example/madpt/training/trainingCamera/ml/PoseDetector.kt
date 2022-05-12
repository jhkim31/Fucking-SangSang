/* Copyright 2021 The TensorFlow Authors. All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
==============================================================================
*/

package com.example.madpt.training.trainingCamera.ml

import android.graphics.Bitmap
import com.example.madpt.training.trainingCamera.data.Person
import com.example.madpt.training.trainingCamera.data.TrainingData

interface PoseDetector : AutoCloseable {

    fun estimatePoses(bitmap: Bitmap): List<Person>
    fun doExcrcise(person: List<Person>): Pair<ArrayList<Int>,ArrayList<Int>>
    fun lastInferenceTimeNanos(): Long
    fun getTrainingData(): ArrayList<TrainingData>
    fun getExcrciseTimeList(): ArrayList<Long>

}
