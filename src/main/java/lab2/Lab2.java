import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

void main() {
    try {
        // variable name:avatarStream
        // type:InputStream
        // primitive or reference:Reference
        var avatarStream = getRandomAvatarStream();
       // showAvatar takes a single argument, which is always a reference type (InputStream).
        showAvatar(avatarStream);
        // Type/class:java.io.IOException
        // package:java.io
        // purpose:Signals I/O errors.
    } catch (IOException | InterruptedException e) {
        // printStackTrace is a instance method
        // printStackTrace return void because it prints the exception's stack trace to standard error
        // variable name:e
        // type:Exception (IOException/InterruptedException)
        // primitive or reference:Reference
        e.printStackTrace();
    }

}
// Type/class:java.io.InputStream
// package:java.io
// purpose:Abstract class representing input streams of bytes.
// parameter:imageStream
// type:InputStream
// argument:Returns from getRandomAvatarStream
// primitive or reference:Reference
InputStream getRandomAvatarStream() throws IOException, InterruptedException {
    // Pick a random style
    // It constructs a new URI object from the string provided.
    // Array literal; constructs a new String array.
    // variable name:styles	String[]
    // type:(array of String)
    // primitive or reference:Reference
    String[] styles = { "adventurer", "adventurer-neutral", "avataaars", "big-ears", "big-ears-neutral", "big-smile", "bottts", "croodles", "croodles-neutral", "fun-emoji", "icons", "identicon", "initials", "lorelei", "micah", "miniavs", "open-peeps", "personas", "pixel-art", "pixel-art-neutral" };

    // random is a class method
    // it is a doubled 0.0 and 1.0 which is returned pseudorandomly
    // Type/class:Math
    // package:java.lang
    // purpose:Utility class for mathematical operations.
    // length is an instant variable
    // variable name:styles
    // type:(array of String)
    // primitive or reference:Reference
    var style = styles[(int)(Math.random() * styles.length)];

    // Generate a random seed
    // random is a class method
    // it is a doubled 0.0 and 1.0 which is returned pseudorandomly
    // Type/class:Math
    // package:java.lang
    // purpose:Utility class for mathematical operations.
    // variable name:seed
    // type:int
    // primitive or reference:Primitive
    var seed = (int)(Math.random() * 10000);

    // Create an HTTP request for a random avatar
    // create is a class method
    // It is a new URI object from the string given.
    // Type/class:java.net.URI
    // package:java.net
    // Purpose:Represents Uniform Resource Identifiers (URI).uri	URI	Reference
    // variable name:uri
    // type:URI
    // primitive or reference: Reference
    var uri = URI.create("https://api.dicebear.com/9.x/%s/png?seed=%d".formatted(style, seed));
    // newBuilder is a class method
    // It is a new builder returned for creating an HTTP request.
    // The build() method on the builder returns a new HttpRequest object.
    // Type/class:java.net.http.HttpRequest
    // package:java.net.http
    // purpose:Represents HTTP requests.
    // variable name:request
    // type:HttpRequest
    // primitive or reference:Reference
    var request = HttpRequest.newBuilder(uri).build();

    // Send the request
    // newHttpClient is a class method
    // It is a new HttpClient instance returned is used to send HTTP requests.
    // It returned a new HttpClient; the method is a static factory but conceptually works as a constructor.
    // Type/class:java.net.http.HttpClient
    // package:java.net.http
    // purpose:Sends HTTP requests and receives responses.
    // variable name:client
    // type:HttpClient
    // primitive or reference:Reference
    try (var client = HttpClient.newHttpClient()) {
        // send is an instant method
        // It sends given request using the client which returns an HttpResponse object.
        var response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
        // body is an instant method
        // It returns the body of the HTTP response., that is  an InputStream
        // Type/class:java.net.http.HttpResponse
        // package:java.net.http
        // purpose:Represents HTTP responses
        // .variable name:response
        // type:HttpResponse<InputStream>
        // primitive or reference:Reference
        return response.body();
    }
}
// Type/class:java.io.InputStream
// package:java.io
// purpose:Abstract class representing input streams of bytes.
// variable name:imageStream
// type:InputStream
// primitive or reference:Reference
void showAvatar(InputStream imageStream) {
    // Allocating a new JFrame with the specified title
    // Type/class: javax.swing.JFrame
    // package: javax.swing
    // Purpose: Main window class for Java GUIs.
    // variable name:frame
    // type:JFrame
    // primitive or reference:Reference
    JFrame frame = new JFrame("PNG Viewer");
    // setDefaultCloseOperation is an instant method
    // It sets the operation that will happen by default when the frame is closed (void return).
    // Type/class:javax.swing.JFrame
    // package:javax.swing
    // purpose:Main window class for Java GUIs.
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // setResizable is an instant method
    // It does not do void return, instead sets whether the frame is resizable
    frame.setResizable(false);
    // setSize is an instant method
    // void return
    frame.setSize(200, 200);
    // getContentPane is an instant method
    //  Gets a Container of the frame.
    // Type/class:java.awt.Color
    // package:java.awt
    // purpose:Encapsulates colors in RGB color space.
    frame.getContentPane().setBackground(Color.BLACK);

    try {
        // Load the PNG image
        // read is a class method
        // It reads an image from an input stream and decodes it into an Image object; returns the new Image.
        // Type/class: javax.imageio.ImageIO
        // package: javax.imageio
        // purpose: Provides methods for reading and writing images.
        // variable name:image
        // type:Image
        // primitive or reference: reference
        Image image = ImageIO.read(imageStream);

        // Create a JLabel to display the image
        // Allocates a new JLabel with an icon, which displays an image.
        // Type/class: javax.swing.JLabel
        // package: javax.swing
        // purpose: Displays a short string/image icon.
        // javax.swing.ImageIcon
        // package:javax.swing	Icon
        // purpose:implementation for image images.
        // variable name:imageLabel
        // type:JLabel
        // primitive or reference:reference
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        // add is an instant method
        // It adds a component to the frame’s content pane with a specific layout constraint.
        // It allocates a new ImageIcon from the given Image object.
        // Type/class:java.awt.BorderLayout
        // package:java.awt
        // purpose:Provides layout for arranging components.
        // variable name:imageLabel
        // type:JLabel
        // primitive or reference:reference
        frame.add(imageLabel, BorderLayout.CENTER);

    } catch (IOException e) {
        // type/class: java.io.IOException
        // package: java.io
        // purpose: Signals I/O errors.

        // printStackTrace is an instant method
        e.printStackTrace();
    }
    // setVisible is an instant method
    // Controls whether the frame is displayed (void return).
    frame.setVisible(true);
}
