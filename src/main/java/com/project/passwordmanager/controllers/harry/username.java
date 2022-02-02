package com.project.passwordmanager.controllers.harry;

import java.util.ArrayList;

class userName

{



    private String firstName;
    private String lastName;
    private int N;
    private String[] possibleUsernames;

    userName( String fN, String lN)
    {

        this.firstName = new String(fN);
        this.lastName = new String(lN);
        N = this.firstName.length();
        possibleUsernames = new String[N];
        CreateUserNames();
    }


    public int GetCount() {
        return(N);
    }

    private void CreateUserNames()
    {
        for (int iLoop=1; iLoop<=N; iLoop++)
        {

            String subStr = firstName.substring(0,iLoop);

            possibleUsernames[iLoop-1]= lastName+subStr;

        }

    }

    String IndexerGetIndexAt( int iIndexPos)
    {
        String strReturn=null;
        if ((iIndexPos>=0) && (iIndexPos<N))
        {
            strReturn = possibleUsernames[iIndexPos];
        }
        return(strReturn);
    }
/*
   public static void main()
    {

        userName myUserNames = new userName("Patrick","Baldwin");
        int n = myUserNames.GetCount();
        for (int iLoop=0; iLoop<n; iLoop++)
        {
            System.out.println( myUserNames.IndexerGetIndexAt(iLoop));
        }
   }
*/


}