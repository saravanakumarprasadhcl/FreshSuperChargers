package com.hcl.fsc.mastertables;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MasterTables {

	@NotEmpty
	private String key;
	@NotEmpty
	private String value;


}
