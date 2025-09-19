package th.co.ais.esb.creven;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class MessageHeader {

    @JacksonXmlProperty(localName = "ID")
    private String id;

    @JacksonXmlProperty(localName = "UUID")
    private String uuid;

    @JacksonXmlProperty(localName = "CreationDateTime")
    private String creationDateTime;

    @JacksonXmlProperty(localName = "SenderBusinessSystemID")
    private String senderBusinessSystemID;

    @JacksonXmlProperty(localName = "RecipientBusinessSystemID")
    private String recipientBusinessSystemID;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(String creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public String getSenderBusinessSystemID() {
		return senderBusinessSystemID;
	}

	public void setSenderBusinessSystemID(String senderBusinessSystemID) {
		this.senderBusinessSystemID = senderBusinessSystemID;
	}

	public String getRecipientBusinessSystemID() {
		return recipientBusinessSystemID;
	}

	public void setRecipientBusinessSystemID(String recipientBusinessSystemID) {
		this.recipientBusinessSystemID = recipientBusinessSystemID;
	}

    
}