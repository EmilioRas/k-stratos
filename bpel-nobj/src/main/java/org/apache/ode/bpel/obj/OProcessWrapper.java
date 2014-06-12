package org.apache.ode.bpel.obj;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.ode.bpel.obj.serde.OmSerdeFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The class maintains all data that should be serialized. Including headers
 * like magic number, format etc. and the BPEL process. The header and whole
 * class could be extended.
 * 
 * An example:
 * {
 * "MAGIC":"VTVTAE9GSCAUBSk=",
 * "FORMAT":16,
 * "COMPILE_TIME":1401935206665,
 * "OTHER_HEADERS":{},
 * "PROCESS":{}
 * }
 * 
 * @author fangzhen
 */
public class OProcessWrapper extends OBase {
	// constants
	public static final byte[] MAGIC_NUMBER_OFH_20140529 = new byte[] { 0x55,
			'5', 'S', 0x00, 'O', 'F', 'H', 0x20, 0x14, 0x05, 0x29 };
	public static final byte[] CURRENT_MAGIC_NUMBER = MAGIC_NUMBER_OFH_20140529;
	// key constants
	public static final String MAGIC_NUMBER = "magic";
	public static final String FORMAT = "format";
	public static final String COMPILE_TIME = "compileTime";
	public static final String GUID = "guid";
	public static final String TYPE = "type";
	public static final String PROCESS = "process";
	public static final String OTHER_HEADERS = "otherHeaders";

	public OProcessWrapper() {
		super(new LinkedHashMap<String, Object>());
	}

	public OProcessWrapper(long compileTime) {
		setMagic(OProcessWrapper.CURRENT_MAGIC_NUMBER);
		setFormat(OmSerdeFactory.FORMAT_SERIALIZED_DEFAULT);
		setCompileTime(compileTime);
		setOtherHeaders(new LinkedHashMap<String, Object>());
	}


	public void checkValid() throws OModelException {
		// TODO Auto-generated method stub

	}
	
	//Accessors
	@JsonIgnore
	public byte[] getMagic() {
		return (byte[])fieldContainer.get(MAGIC_NUMBER);
	}

	public void setMagic(byte[] magic) {
		fieldContainer.put(MAGIC_NUMBER, magic);
	}

	@JsonIgnore
	public short getFormat() {
		return (short)fieldContainer.get(FORMAT);
	}

	public void setFormat(short format) {
		fieldContainer.put(FORMAT, format);
	}

	@JsonIgnore
	public long getCompileTime() {
		return (long)fieldContainer.get(COMPILE_TIME);
	}

	public void setCompileTime(long compileTime) {
		fieldContainer.put(COMPILE_TIME, compileTime);
	}

	@JsonIgnore
	public String getGuid() {
		return (String)fieldContainer.get(GUID);
	}

	public void setGuid(String guid) {
		fieldContainer.put(GUID, guid);
	}

	@JsonIgnore
	@SuppressWarnings("unchecked")
	public Map<String, Object> getOtherHeaders() {
		return (Map<String, Object>)fieldContainer.get(OTHER_HEADERS);
	}

	public void setOtherHeaders(Map<String, Object> otherHeaders) {
		fieldContainer.put(OTHER_HEADERS, otherHeaders);
	}

	@JsonIgnore
	public OProcess getProcess() {
		return (OProcess)fieldContainer.get(PROCESS);
	}
	public void setOProcess(OProcess process) {
		fieldContainer.put(OProcessWrapper.PROCESS, process);
	}
}
