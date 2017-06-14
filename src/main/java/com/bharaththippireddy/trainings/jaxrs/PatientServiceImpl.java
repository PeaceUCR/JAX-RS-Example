package com.bharaththippireddy.trainings.jaxrs;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;

public class PatientServiceImpl implements PatientService {
	private long currentId = 123;
	Map<Long, Patient> patients = new HashMap<Long, Patient>();
	Map<Long, Prescription> prescriptions = new HashMap<Long, Prescription>();

	public PatientServiceImpl() {
		init();
	}

	final void init() {
		Patient patient = new Patient();
		patient.setName("John");
		patient.setId(currentId);
		patients.put(patient.getId(), patient);

		Prescription prescription = new Prescription();
		prescription.setDescription("prescription 223");
		prescription.setId(223);
		prescriptions.put(prescription.getId(), prescription);
	}

	public Response addPatient(Patient patient) {
		System.out.println("addPatient called:"+patient.getName());
		patient.setId(++currentId);
		patients.put(patient.getId(),patient);
		return Response.ok(patient).build();
	}

	public Patient getPatient(String id) {
		Long idNumber = Long.parseLong(id);
		Patient p = patients.get(idNumber);
		return p;
	}

	public Response updatePatient(Patient updatedPatient) {
		Patient p=patients.get(updatedPatient.getId());
		Response r=null;
		if(p!=null){
			patients.put(updatedPatient.getId(), updatedPatient);
			r= Response.ok().build();
		}else{
			r= Response.notModified().build();
		}
		return r;
	}

	public Response deletePatients(String id) {
		Long idNumber = Long.parseLong(id);
		Patient p = patients.get(idNumber);
		Response r=null;
		if(p!=null){
			patients.remove(idNumber);
			r=Response.ok().build();
		}else{
			r= Response.notModified().build();
		}
		return r;
	}

	public Prescription getPrescription(String prescriptionId) {

		return null;
	}

}
