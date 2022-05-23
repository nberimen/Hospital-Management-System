package com.nberimen.hospitalmanagementsystem.medicine;

import com.nberimen.hospitalmanagementsystem.medicine.dto.MedicineDto;
import com.nberimen.hospitalmanagementsystem.medicine.dto.MedicineSaveRequestDto;
import com.nberimen.hospitalmanagementsystem.medicine.entityservice.MedicineEntityService;
import com.nberimen.hospitalmanagementsystem.prescription.PrescriptionService;
import com.nberimen.hospitalmanagementsystem.prescription.dto.PrescriptionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MedicineService {

    private final MedicineEntityService medicineEntityService;
    private final PrescriptionService prescriptionService;

    public MedicineDto save(MedicineSaveRequestDto medicineSaveRequestDto) {
        Medicine medicine = MedicineMapper.INSTANCE.convertToMedicine(medicineSaveRequestDto);
        medicine = medicineEntityService.save(medicine);
        MedicineDto medicineDto = MedicineMapper.INSTANCE.convertToMedicineDto(medicine);
        return medicineDto;
    }

    public List<MedicineDto> findAllByPrescriptionId(Long prescriptionId) {
        List<Medicine> medicineList = medicineEntityService.findAllByPrescriptionId(prescriptionId);
        List<MedicineDto> medicineDtoList = getMedicineDtoList(medicineList);
        return medicineDtoList;
    }


    public MedicineDto findById(Long id) {
        Medicine medicine = medicineEntityService.getById(id);
        MedicineDto medicineDto = MedicineMapper.INSTANCE.convertToMedicineDto(medicine);
        PrescriptionDto prescriptionDto = prescriptionService.findById(medicine.getPrescriptionId());
        medicineDto.setPrescriptionDto(prescriptionDto);
        return medicineDto;
    }


    private List<MedicineDto> getMedicineDtoList(List<Medicine> medicineList) {
        List<MedicineDto> medicineDtoList = new ArrayList<>();
        for (Medicine medicine : medicineList) {
            PrescriptionDto prescriptionDto = prescriptionService.findById(medicine.getPrescriptionId());
            MedicineDto medicineDto = MedicineMapper.INSTANCE.convertToMedicineDto(medicine);
            medicineDto.setPrescriptionDto(prescriptionDto);
            medicineDtoList.add(medicineDto);
        }
        return medicineDtoList;
    }
}
