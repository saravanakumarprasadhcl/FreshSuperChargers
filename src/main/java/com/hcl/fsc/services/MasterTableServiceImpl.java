package com.hcl.fsc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hcl.fsc.mastertables.CollegeTiering;
import com.hcl.fsc.mastertables.Gender;
import com.hcl.fsc.mastertables.L1;
import com.hcl.fsc.mastertables.L2;
import com.hcl.fsc.mastertables.L3;
import com.hcl.fsc.mastertables.L4;
import com.hcl.fsc.mastertables.LOB;
import com.hcl.fsc.mastertables.Location;
import com.hcl.fsc.mastertables.MasterTables;
import com.hcl.fsc.mastertables.OfferedBand;
import com.hcl.fsc.mastertables.OfferedDesignation;
import com.hcl.fsc.mastertables.OfferedSubBand;
import com.hcl.fsc.mastertables.OnboardingStatus;
import com.hcl.fsc.mastertables.Region;
import com.hcl.fsc.mastertables.State;
import com.hcl.fsc.mastertables.UGDegree;
import com.hcl.fsc.repositories.CollegeTieringRepository;
import com.hcl.fsc.repositories.EmployeeDetailsRepository;
import com.hcl.fsc.repositories.GenderRepository;
import com.hcl.fsc.repositories.L1Repository;
import com.hcl.fsc.repositories.L2Repository;
import com.hcl.fsc.repositories.L3Repository;
import com.hcl.fsc.repositories.L4Repository;
import com.hcl.fsc.repositories.LOBRepository;
import com.hcl.fsc.repositories.LocationRepository;
import com.hcl.fsc.repositories.OfferedBandRepository;
import com.hcl.fsc.repositories.OfferedDesignationRepository;
import com.hcl.fsc.repositories.OfferedSubBandRepository;
import com.hcl.fsc.repositories.OnboardingStatusRepository;
import com.hcl.fsc.repositories.RegionRepository;
import com.hcl.fsc.repositories.StateRepository;
import com.hcl.fsc.repositories.UGDegreeRepository;


@Service
public class MasterTableServiceImpl {

//	public void deleteGender(String genderkey) {
//		Gender gender=this.genderRepository.getByGenderKey(genderkey);
//		this.genderRepository.delete(gender);
//	}

	private EmployeeDetailsRepository employeeDetailsRepository;

	@Autowired
	private GenderRepository genderRepository;

	@Autowired
	private LOBRepository lobRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private RegionRepository regionRepository;

	@Autowired
	private CollegeTieringRepository collegeTieringRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private L1Repository l1Repository;

	@Autowired
	private L2Repository l2Repository;

	@Autowired
	private L3Repository l3Repository;

	@Autowired
	private L4Repository l4Repository;

	@Autowired
	private UGDegreeRepository ugDegreeRepository;

	@Autowired
	private OnboardingStatusRepository onboardingStatusRepository;

	@Autowired
	private OfferedBandRepository offeredBandRepository;

	@Autowired
	private OfferedSubBandRepository offeredSubBandRepository;

	@Autowired
	private OfferedDesignationRepository offeredDesignationRepository;

	public List getRecord(String mastertable) {
		return repo(mastertable).findAll();

	}

	public JpaRepository repo(String mastertable) {
		// int res=0;
		mastertable = mastertable.toLowerCase();
		// if(mastertable!=null && mastertable!="") {

		if (mastertable.equals("gender")) {
			return this.genderRepository;
		} else if (mastertable.equals("lob")) {

			return this.lobRepository;
		} else if (mastertable.equals("location")) {
			return this.locationRepository;
		} else if (mastertable.equals("region")) {
			return this.regionRepository;
		} else if (mastertable.equals("collegeTiering")) {
			return this.collegeTieringRepository;
		} else if (mastertable.equals("state")) {
			return this.stateRepository;
		} else if (mastertable.equals("l1")) {
			return this.l1Repository;
		}

		else if (mastertable.equals("l2")) {
			return this.l2Repository;
		}

		else if (mastertable.equals("l3")) {
			return this.l3Repository;
		}

		else if (mastertable.equals("l4")) {
			return this.l4Repository;
		}

		else if (mastertable.equals("ugdegree")) {
			return this.ugDegreeRepository;
		}


		else if (mastertable.equals("offeredband")) {
			return this.offeredBandRepository;
		} else if (mastertable.equals("offeredsubband")) {
			return this.offeredSubBandRepository;
		}

		else if (mastertable.equals("offereddesignation")) {
			return this.offeredDesignationRepository;
		} else if (mastertable.equals("onboardingstatus")) {
			return this.onboardingStatusRepository;
		}

		return this.collegeTieringRepository;

		// return res;
	}

	public Optional getRecordbyKey(String mastertable, String key) {
		return repo(mastertable.toLowerCase()).findById(key.toUpperCase());

	}

//    public List createData(String mastertable, Iterable str) {
//		return repo(mastertable).saveAll(str);
//
//    }
//
	public int createData(MasterTables master, String str) {
		int res = 0;
		str = str.toLowerCase();
		if (master.getKey() != null && master.getKey() != "") {
			if (str.equals("gender")) {

//		Gender obj1=new Gender();
//		obj1.setGENDERKEY(master.getKey());
//		obj1.setGENDERVALUE(master.getValue());
//		genderRepository.save(obj1);
//    	Gender obj = new Gender(master.getKey(), master.getValue());
//   	genderRepository.save(new Gender(master.getKey(), master.getValue()));

				genderRepository.save(new Gender(0, master.getKey(), master.getValue()));

			}

			else if (str.equals("lob")) {

				lobRepository.save(new LOB(0, master.getKey(), master.getValue()));

			}

			else if (str.equals("location")) {

				locationRepository.save(new Location(0, master.getKey(), master.getValue()));
			} else if (str.equals("region")) {

				regionRepository.save(new Region(0, master.getKey(), master.getValue()));

			} else if (str.equals("collegetiering")) {

				collegeTieringRepository.save(new CollegeTiering(0, master.getKey(), master.getValue()));

			} else if (str.equals("state")) {

				stateRepository.save(new State(0, master.getKey(), master.getValue()));

			} else if (str.equals("l1")) {

				l1Repository.save(new L1(0, master.getKey(), master.getValue()));

			} else if (str.equals("l2")) {

				l2Repository.save(new L2(0, master.getKey(), master.getValue()));

			} else if (str.equals("l3")) {

				l3Repository.save(new L3(0, master.getKey(), master.getValue()));

			} else if (str.equals("l4")) {

				l4Repository.save(new L4(0, master.getKey(), master.getValue()));

			} else if (str.equals("ugdegree")) {

				ugDegreeRepository.save(new UGDegree(0, master.getKey(), master.getValue()));
			}else if (str.equals("offeredband")) {

				offeredBandRepository.save(new OfferedBand(0, master.getKey(), master.getValue()));

			} else if (str.equals("offeredsubband")) {

				offeredSubBandRepository.save(new OfferedSubBand(0, master.getKey(), master.getValue()));

			} else if (str.equals("offereddesignation")) {

				offeredDesignationRepository.save(new OfferedDesignation(0, master.getKey(), master.getValue()));

			} else if (str.equals("onboardingstatus")) {

				onboardingStatusRepository.save(new OnboardingStatus(0, master.getKey(), master.getValue()));

			}
			res++;
		}
		return res;

	}

	// static int rowTotal;
//	List<Product> products;
	public int save(MultipartFile file) {
		int res = 0;

		return res;
	}

//	public List<Employee> getAllCandidates(){
//		return this.candidateRepository.findAll();
//	}
//
//	public List<Gender> getAllGender(){
//		return this.genderRepository.findAll();
//    }
//	public List<Lob> getAllLob(){
//		return this.lobRepository.findAll();
//    }
//    public Gender addGender(Gender gender) {
//		return genderRepository.save(gender);
//
//    }

//
//	public void updateGender(String genderkey, Gender gender) {
//		Gender g=genderRepository.getById(genderkey);
//		g.setGENDERVALUE(gender.getGENDERVALUE());
//		genderRepository.save(g);
//
//	}

//	public void deleteGender(String genderkey) {
//		genderRepository.deleteById(genderkey);
//	}

	public int updateRecord(String key, MasterTables master, String str) {
		int res = 0;
		str = str.toLowerCase();
		key = key.toUpperCase();
		if (master.getValue() != null && master.getValue() != "") {
			if (str.equals("gender")) {

				Gender obj1 = genderRepository.getOne(key);
				obj1.setValue(master.getValue());
				genderRepository.save(obj1);
				
			}

			else if (str.equals("lob")) {
				LOB obj2 = lobRepository.getOne(key);
				obj2.setValue(master.getValue());
				lobRepository.save(obj2);
				
			}

			else if (str.equals("location")) {
				Location obj3 = locationRepository.getOne(key);
				obj3.setValue(master.getValue());
				locationRepository.save(obj3);
			}

			else if (str.equals("region")) {
				Region obj4 = regionRepository.getOne(key);
				obj4.setValue(master.getValue());
				regionRepository.save(obj4);
			}

			else if (str.equals("collegetiering")) {
				CollegeTiering obj5 = collegeTieringRepository.getOne(key);
				obj5.setValue(master.getValue());
				collegeTieringRepository.save(obj5);
			}

			else if (str.equals("state")) {
				State obj6 = stateRepository.getOne(key);
				obj6.setValue(master.getValue());
				stateRepository.save(obj6);
			} else if (str.equals("l1")) {
				L1 obj7 = l1Repository.getOne(key);
				obj7.setValue(master.getValue());
				l1Repository.save(obj7);
			} else if (str.equals("l2")) {
				L2 obj8 = l2Repository.getOne(key);
				obj8.setValue(master.getValue());
				l2Repository.save(obj8);
			} else if (str.equals("l3")) {
				L3 obj9 = l3Repository.getOne(key);
				obj9.setValue(master.getValue());
				l3Repository.save(obj9);
			} else if (str.equals("l4")) {
				L4 obj10 = l4Repository.getOne(key);
				obj10.setValue(master.getValue());
				l4Repository.save(obj10);
			} else if (str.equals("ugdegree")) {
				UGDegree obj11 = ugDegreeRepository.getOne(key);
			//	obj11.setUGDEGREEVALUE(master.getValue());
				ugDegreeRepository.save(obj11);
			} else if (str.equals("offeredband")) {
				OfferedBand obj14 = offeredBandRepository.getOne(key);
				obj14.setValue(master.getValue());
				offeredBandRepository.save(obj14);
			} else if (str.equals("offeredsubband")) {
				OfferedSubBand obj15 = offeredSubBandRepository.getOne(key);
				obj15.setValue(master.getValue());
				offeredSubBandRepository.save(obj15);
			} else if (str.equals("offereddesignation")) {
				OfferedDesignation obj16 = offeredDesignationRepository.getOne(key);
				obj16.setValue(master.getValue());
				offeredDesignationRepository.save(obj16);
			} else if (str.equals("onboardingstatus")) {
				OnboardingStatus obj17 = onboardingStatusRepository.getOne(key);
			//	obj17.setONBOARDINGSTATUSVALUE(master.getValue());
				onboardingStatusRepository.save(obj17);
			}
			res++;
		}
		return res;
	}

	public void deleteRecord(String key, String str) {
		str = str.toLowerCase();
		key = key.toUpperCase();
		{
			if (str.equals("gender")) {
//			Gender obj1=genderRepository.deleteById(str);
				Optional<Gender> obj1 = genderRepository.findById(key);
				genderRepository.deleteById(obj1.get().getKey());
				
			}

			else if (str.equals("lob")) {
				Optional<LOB> obj2 = lobRepository.findById(key);
				lobRepository.deleteById(obj2.get().getKey());
			} else if (str.equals("location")) {
				Optional<Location> obj3 = locationRepository.findById(key);
				locationRepository.deleteById(obj3.get().getKey());
			}

			else if (str.equals("region")) {
				Optional<Region> obj4 = regionRepository.findById(key);
				regionRepository.deleteById(obj4.get().getKey());
			}

			else if (str.equals("collegetiering")) {
				Optional<CollegeTiering> obj5 = collegeTieringRepository.findById(key);
				collegeTieringRepository.deleteById(obj5.get().getKey());
			}

			else if (str.equals("state")) {
				Optional<State> obj6 = stateRepository.findById(key);
				stateRepository.deleteById(obj6.get().getKey());
			}

			else if (str.equals("l1")) {
				Optional<L1> obj7 = l1Repository.findById(key);
				l1Repository.deleteById(obj7.get().getKey());
			}

			else if (str.equals("l2")) {
				Optional<L2> obj8 = l2Repository.findById(key);
				l2Repository.deleteById(obj8.get().getKey());
			}

			else if (str.equals("l3")) {
				Optional<L3> obj9 = l3Repository.findById(key);
				l3Repository.deleteById(obj9.get().getKey());
			}

			else if (str.equals("l4")) {
				Optional<L4> obj10 = l4Repository.findById(key);
				l4Repository.deleteById(obj10.get().getKey());
			} else if (str.equals("ugdegree")) {
				Optional<UGDegree> obj11 = ugDegreeRepository.findById(key);
				ugDegreeRepository.deleteById(obj11.get().getKey());
			}


			else if (str.equals("offeredband")) {
				Optional<OfferedBand> obj14 = offeredBandRepository.findById(key);
				offeredBandRepository.deleteById(obj14.get().getKey());
			} else if (str.equals("offeredsubband")) {
				Optional<OfferedSubBand> obj15 = offeredSubBandRepository.findById(key);
				offeredSubBandRepository.deleteById(obj15.get().getKey());
			}

			else if (str.equals("offereddesignation")) {
				Optional<OfferedDesignation> obj16 = offeredDesignationRepository.findById(key);
				offeredDesignationRepository.deleteById(obj16.get().getKey());
			} else if (str.equals("onboardingstatus")) {
				Optional<OnboardingStatus> obj17 = onboardingStatusRepository.findById(key);
				onboardingStatusRepository.deleteById(obj17.get().getKey());
			}
		}
	}

}
