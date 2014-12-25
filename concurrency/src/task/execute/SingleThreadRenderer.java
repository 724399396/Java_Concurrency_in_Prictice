package task.execute;

import java.util.ArrayList;
import java.util.List;

public abstract class SingleThreadRenderer {
	void renderPage(CharSequence source) {
		renderText(source);
		List<ImageData> imageData = new ArrayList<ImageData>();
		for (ImageInfo imageInfo : scanFromImageInfo(source))
			imageData.add(imageInfo.downloadImage());
		for (ImageData data : imageData)
			renderImage(data);
	}
	
	interface ImageData {}
	
	interface ImageInfo {
		ImageData downloadImage();
	}
	
	abstract void renderText(CharSequence s);
	abstract List<ImageInfo> scanFromImageInfo(CharSequence s);
	abstract void renderImage(ImageData i);
}
