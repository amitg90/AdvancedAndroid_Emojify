package com.example.android.emojify;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.util.SparseArray;
import android.widget.Toast;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.face.Face;
import com.google.android.gms.vision.face.FaceDetector;

public class Emojifier {

    public static void detectFaces(Context context, Bitmap bitmap) {
        FaceDetector faceDetector = new FaceDetector.Builder(context)
                .setTrackingEnabled(false)
                .setClassificationType(FaceDetector.ALL_CLASSIFICATIONS)
                .build();

        // Build the frame
        Frame frame = new Frame.Builder().setBitmap(bitmap).build();

        // Detect the faces
        SparseArray<Face> faces = faceDetector.detect(frame);

        // Log the number of faces
        Log.d("Emojifier", "detectFaces: number of faces = " + faces.size());

        // If there are no faces detected, show a Toast message
        if(faces.size() == 0){
            Toast.makeText(context, "No Faced found", Toast.LENGTH_SHORT).show();
        }

        // Release the detector
        faceDetector.release();
    }

}
