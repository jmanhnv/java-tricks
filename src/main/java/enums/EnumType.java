package enums;

import com.google.common.base.Strings;

import constants.Const;

public final class EnumType implements Const {
	public enum FileType {
		TXT(".txt"), JSON(".json");

		private String extension;

		private FileType(final String ext) {
			extension = ext;
		}

		public String getExtension() {
			return extension;
		}

		@Override
		public String toString() {
			return Strings.nullToEmpty(extension);
		}
	}

	public enum MimeType {
		// http://webdesign.about.com/od/multimedia/a/mime-types-by-content-type.htm
	}

	public enum CharacterType {
		DOT(Const.DOT), SPACE(Const.SPACE), UNDERSCORE(Const.HYPHEN);

		private String str;

		private CharacterType(final String s) {
			str = s;
		}

		@Override
		public String toString() {
			return str;
		}
	}

	public enum ContactType {
		DR("Dr."), MR("Mr."), MISS("Miss."), MS("Ms."), MRS("Mrs."), PROF("Prof.");

		private String title;

		private ContactType(final String newTitle) {
			this.title = newTitle;
		}

		@Override
		public String toString() {
			return title;
		}
	}
}
