package com.example.udaysaikumar.rankquest.MongoHQ;

import com.example.udaysaikumar.rankquest.MyContact;

/**
 * Created by udaysaikumar on 28/01/18.
 */

public class QueryBuilder {


        /**
         * Specify your database name here
         * @return
         */
        public String getDatabaseName() {
          return "usk";
        //return "eamcet";
    }

        /**
         * Specify your MongoLab API here
         * @return
         */
    public String getApiKey() {
        return "KmTJIck8DgWEJikNyhwTNF7cy760f9iW";
       // return "HuAOkrar3PipOZeK6wI9cFDGxYzDuWPA";
    }

    /**
     * This constructs the URL that allows you to manage your database,
     * collections and documents
     * @return
     */
    public String getBaseUrl()
    {
        return "https://api.mongolab.com/api/1/databases/"+getDatabaseName()+"/collections/";
    }

    /**
     * Completes the formating of your URL and adds your API key at the end
     * @return
     */
    public String docApiKeyUrl()
    {
        return "?apiKey="+getApiKey();
    }

    /**
     * Get a specified document
     * @param docid
     * @return
     */
    public String docApiKeyUrl(String docid)
    {
        return "/"+docid+"?apiKey="+getApiKey();
    }

    /**
     * Returns the docs101 collection
     * @return
     */
    public String documentRequest()
    {
        return "feedback";
    }

    /**
     * Builds a complete URL using the methods specified above
     * @return
     */
    public String buildContactsSaveURL()
    {
        return getBaseUrl()+documentRequest()+docApiKeyUrl();
    }

    /**
     * This method is identical to the one above.
     * @return
     */
    public String buildContactsGetURL()
    {
        return getBaseUrl()+documentRequest()+docApiKeyUrl();
    }

    /**
     * Get a Mongodb document that corresponds to the given object id
     * @param doc_id
     * @return
     */
    public String buildContactsUpdateURL(String doc_id)
    {
        return getBaseUrl()+documentRequest()+docApiKeyUrl(doc_id);
    }


    /**
     * Formats the contact details for MongoHLab Posting
     * @param contact: Details of the person
     * @return
     */
    public String createContact(MyContact contact)
    {
        return String
                .format("{\"phno\":\"%s\","
                                +"\"bug\": \"%s\", "
                                + "\"improve\": \"%s\", "
                                + "\"rating\": \"%s\"}",
                        contact.phno,contact.bug, contact.improve, contact.rating);
      /*  return String
                .format("{\"bug\": \"%s\", "
                                + "\"improve\": \"%s\", "
                                + "\"rating\": \"%s\"}",
                        contact.bug, contact.improve, contact.rating);*/
    }

    /**
     * Update a given contact record
     * @param contact
     * @return
     */
    public String setContactData(MyContact contact) {
       /* return String.format("{ \"$set\" : "
                        + "{\"first_name\" : \"%s\", "
                        + "\"last_name\" : \"%s\", "
                        + "\"email\" : \"%s\", "
                        + "\"phone\" : \"%s\" }" + "}",
                contact.getFirst_name(),
                contact.getLast_name(), contact.getEmail(),
                contact.getPhone());*/
       return "hi";
    }

}

