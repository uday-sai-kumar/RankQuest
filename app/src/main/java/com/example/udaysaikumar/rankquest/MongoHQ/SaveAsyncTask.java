package com.example.udaysaikumar.rankquest.MongoHQ;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.widget.ProgressBar;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import com.example.udaysaikumar.rankquest.MyContact;
import com.rankquest.udaysaikumar.rankquest.FeedBack;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by udaysaikumar on 28/01/18.
 */

public class SaveAsyncTask extends AsyncTask<MyContact, Void, Boolean> {
   protected ProgressDialog dialog;
   boolean test=false;
    Context context;
    public SaveAsyncTask(Context context){
this.context=context;
    }

@Override
protected void onPreExecute(){
     dialog=new ProgressDialog(context);
     dialog.setIndeterminate(true);
     dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
     dialog.setCancelable(false);
    dialog.setMessage("please wait");
    dialog.show();


}

        @Override
        protected Boolean doInBackground(MyContact... arg0) {
            try
            {
                final MyContact contact = arg0[0];

                QueryBuilder qb = new QueryBuilder();

                HttpClient httpClient = new DefaultHttpClient();
                HttpPost request = new HttpPost(qb.buildContactsSaveURL());

                StringEntity params =new StringEntity(qb.createContact(contact));
                request.addHeader("content-type", "application/json");
                request.setEntity(params);
                HttpResponse response = httpClient.execute(request);
                System.out.println("\n\n\n\nhi usk \n\n\n");


                if(response.getStatusLine().getStatusCode()<205)
                {
                  test=true;
                    return true;
                }
                else
                {
                   test=false;
                   // Toast.makeText(SaveAsyncTask.this,"please connect to network",Toast.LENGTH_SHORT).show();
                    return false;
                }
            } catch (Exception e) {
                //e.getCause();
                String val = e.getMessage();
                String val2 = val;
                return false;
            }
          /*  new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    dialog.dismiss();
                }
            },5000);*/
        }
        @Override
    public void onPostExecute(final Boolean b){
if(dialog.isShowing()){
    dialog.dismiss();
}
if(test) {
    Toast.makeText(context, "feedback updated successfully", Toast.LENGTH_SHORT).show();
}
else {
     Toast.makeText(context,"please connect to network",Toast.LENGTH_SHORT).show();

}
        }


    }
