package com.twilio.MailManagement.mailmanagementservice.model;

import javax.validation.constraints.NotNull;

public class Discount {
		@NotNull
		private String name;
		@NotNull
		private String email;
		@NotNull
		private String text;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getText() {
			return text;
		}
		public void setText(String text) {
			this.text = text;
		}
	
}
