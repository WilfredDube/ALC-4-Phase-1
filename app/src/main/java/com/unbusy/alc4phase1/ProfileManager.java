package com.unbusy.alc4phase1;

public class ProfileManager {
    public static ProfileManager profileManager = null;

    private UserProfileInfo userProfileInfo ;

    public static ProfileManager getInstance(){
        if (profileManager == null){
            profileManager = new ProfileManager();
            profileManager.setDefaultProfile();
        }

        return profileManager;
    }

    public UserProfileInfo getUserProfileInfo() {
        return userProfileInfo;
    }

    private void setDefaultProfile() {
        final ProfileManager pm = getInstance();

        profileManager.userProfileInfo =
                new UserProfileInfo(
                        "Wilfred Dube", "@wilfreddube",
                        "Android Track", "Zimbabwe", "wilfreddube@gmail.com",
                        "+263777961088"
                );
    }

    public static void updateProfileManager(UserProfileInfo userProfileInfo) {
        ProfileManager.profileManager.userProfileInfo = userProfileInfo;
    }
}
