package creational.prototype;

import java.util.ArrayList;
import java.util.List;

class VideoEditorProject implements Prototype<VideoEditorProject> {

    private String filename;
    private String encoding;
    private List<String> overlays;

    public VideoEditorProject(String filename, String encoding) {
        this.filename = filename;
        this.encoding = encoding;
        this.overlays = new ArrayList<>();
    }

    public VideoEditorProject(VideoEditorProject source) {
        this.filename = source.filename + "_copy";
        this.encoding = source.encoding;
        this.overlays = new ArrayList<>(source.overlays);
    }

    @Override
    public VideoEditorProject copy() {
        return new VideoEditorProject(this);
    }

    public void addOverlay(String overlay) {
        this.overlays.add(overlay);
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String toString() {
        return "Project[file=" + filename + ", enc=" + encoding + ", overlays=" + overlays + "]";
    }
}
