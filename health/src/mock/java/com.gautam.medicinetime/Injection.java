package com.gautam.medicinetime;

import android.content.Context;
import androidx.annotation.NonNull;

import com.gautam.medicinetime.data.source.MedicineRepository;
import com.gautam.medicinetime.data.source.local.MedicinesLocalDataSource;

public class Injection {

    public static MedicineRepository provideMedicineRepository(@NonNull Context context) {
        return MedicineRepository.getInstance(MedicinesLocalDataSource.getInstance(context));
    }
}
