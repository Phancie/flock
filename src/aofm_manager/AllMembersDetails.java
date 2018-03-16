/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aofm_manager;

/**
 *
 * @author REUBEN
 */
public class AllMembersDetails {
        String id;
        String fname;
        String mname;
        String lname;
        String dob;
        String phone;
        String area;
        String status;
        
        public AllMembersDetails(String id, String fname, String mname, String lname, String dob, String phone, String area, String status) {
            this.id = id;
            this.fname = fname;
            this.mname = mname;
            this.lname = lname;
            this.dob = dob;
            this.phone = phone;
            this.area = area;
            this.status = status;
        }

        public String getId() {
            return id;
        }

        public String getFname() {
            return fname;
        }

        public String getMname() {
            return mname;
        }

        public String getLname() {
            return lname;
        }

        public String getDob() {
            return dob;
        }

        public String getPhone() {
            return phone;
        }

        public String getArea() {
            return area;
        }

        public String getStatus() {
            return status;
        }
        
    
}
