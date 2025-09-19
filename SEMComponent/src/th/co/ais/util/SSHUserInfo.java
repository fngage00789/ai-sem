package th.co.ais.util;
import org.apache.log4j.spi.LoggerFactory;

import com.jcraft.jsch.UserInfo;

public final class SSHUserInfo implements UserInfo {

    /** The password. */
    private final String password;
    /** True, if the password or pass phrase has been retrieved at least once. 
*/
    private boolean secretDelivered = false;
    /** The keyFile. */
    private final String keyFile;
    /** True, if the pass phrase has been retrieved at least once. */
    private final String passphrase;

    /**
     * Create UserInfo for password authentication.
     *
     * @param password Password of the remote user.
     */
    public SSHUserInfo(final String password) {

        super();
        System.out.println("SSHUserInfo(********)");
        this.password = password;
        this.keyFile = null;
        this.passphrase = null;
    }

    /**
     * Create UserInfo for public key/passphrase authentication.
     *
     * @param keyFileName File containing the (one of the) users's private key.
     * @param passphrase Passphrase securing the keyfile.
     */
    public SSHUserInfo(final String keyFileName, final String passphrase) {

        super();
        System.out.println("SSHUserInfo(" + keyFileName + ", ********)");
        this.password = null;
        this.keyFile = keyFileName;
        this.passphrase = passphrase;
    }

    /**
     * {...@inheritdoc}
     *
     * @see com.jcraft.jsch.UserInfo#getPassphrase()
     */
    public String getPassphrase() {

        System.out.println("getPassphrase()=********");
        secretDelivered = true;
        return passphrase;
    }

    /**
     * {...@inheritdoc}
     *
     * @see com.jcraft.jsch.UserInfo#getPassword()
     */
    public String getPassword() {

        System.out.println("getPassword()=********");
        secretDelivered = true;
        return password;
    }

    /**
     * {...@inheritdoc}
     *
     * @see com.jcraft.jsch.UserInfo#promptPassword(java.lang.String)
     */
    public boolean promptPassword(final String message) {

        // Tell Jsch prompting for PW was successful the first time, but
        // failed if asked more than once (the first pw did not work, we
        // got only one.
        System.out.println("promptPassword(" + message + ")=" + !secretDelivered);
        return !secretDelivered;
    }

    /**
     * {...@inheritdoc}
     *
     * @see com.jcraft.jsch.UserInfo#promptPassphrase(java.lang.String)
     */
    public boolean promptPassphrase(final String message) {

        // Tell JSCH prompting for pass phrase was successful the first time, but
        // failed if asked more than once (the first pass phrase did not work, we got only one).
        System.out.println("promptPassphrase(" + message + ")=" + !secretDelivered);
        return !secretDelivered;
    }

    /**
     * {...@inheritdoc}
     *
     * @see com.jcraft.jsch.UserInfo#promptYesNo(java.lang.String)
     */
    public boolean promptYesNo(final String message) {

        System.out.println("promptYesNo(" + message + ")=true");
        // Used, if known hosts check failed (i.e. host key not known).
        // Answer means: continue anyways
        return true;
    }

    /**
     * {...@inheritdoc}
     *
     * @see com.jcraft.jsch.UserInfo#showMessage(java.lang.String)
     */
    public void showMessage(final String message) {

        System.out.println("showMessage(" + message + ")");
    }

    /**
     * @return Returns the key file.
     */
    public String getKeyFile() {

        System.out.println("getKeyFile()=" + keyFile);
        return keyFile;
    }

}