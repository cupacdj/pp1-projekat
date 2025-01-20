/* The following code was generated by JFlex 1.4.3 on 20.1.25. 17:38 */

package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;



/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 20.1.25. 17:38 from the specification file
 * <tt>spec/mjlexer.lex</tt>
 */
class Yylex implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int COMMENT = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\10\0\1\1\1\1\1\3\1\0\1\1\1\2\22\0\1\1\1\47"+
    "\3\0\1\35\1\52\1\55\1\41\1\42\1\33\1\31\1\40\1\32"+
    "\1\0\1\34\12\54\1\0\1\37\1\51\1\36\1\50\2\0\32\56"+
    "\1\45\1\0\1\46\1\0\1\57\1\0\1\10\1\27\1\17\1\23"+
    "\1\15\1\24\1\7\1\26\1\12\1\56\1\30\1\25\1\11\1\13"+
    "\1\6\1\4\1\56\1\5\1\20\1\14\1\16\1\22\1\21\3\56"+
    "\1\43\1\53\1\44\uff82\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\1\1\17\3\1\4\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\1\1\1\22\1\23\2\1\1\24"+
    "\1\1\2\25\3\3\1\26\7\3\1\27\2\3\1\30"+
    "\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\0"+
    "\1\40\4\3\1\41\1\42\10\3\1\43\2\3\1\44"+
    "\1\3\1\45\1\46\4\3\1\47\2\3\1\50\1\3"+
    "\1\51\1\3\1\52\1\53\1\54\1\3\1\55\1\3"+
    "\1\56\1\3\1\57";

  private static int [] zzUnpackAction() {
    int [] result = new int[108];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\60\0\140\0\140\0\220\0\300\0\360\0\u0120"+
    "\0\u0150\0\u0180\0\u01b0\0\u01e0\0\u0210\0\u0240\0\u0270\0\u02a0"+
    "\0\u02d0\0\u0300\0\u0330\0\u0360\0\u0390\0\u03c0\0\140\0\u03f0"+
    "\0\140\0\u0420\0\140\0\140\0\140\0\140\0\140\0\140"+
    "\0\140\0\140\0\u0450\0\u0480\0\u04b0\0\u04e0\0\u0510\0\u0540"+
    "\0\u0570\0\140\0\u05a0\0\u05d0\0\u0600\0\u0630\0\u0120\0\u0660"+
    "\0\u0690\0\u06c0\0\u06f0\0\u0720\0\u0750\0\u0780\0\u0120\0\u07b0"+
    "\0\u07e0\0\140\0\140\0\140\0\140\0\140\0\140\0\140"+
    "\0\140\0\u0810\0\140\0\u0840\0\u0870\0\u08a0\0\u08d0\0\u0120"+
    "\0\u0120\0\u0900\0\u0930\0\u0960\0\u0990\0\u09c0\0\u09f0\0\u0a20"+
    "\0\u0a50\0\140\0\u0a80\0\u0ab0\0\u0120\0\u0ae0\0\u0120\0\u0120"+
    "\0\u0b10\0\u0b40\0\u0b70\0\u0ba0\0\u0120\0\u0bd0\0\u0c00\0\u0120"+
    "\0\u0c30\0\u0120\0\u0c60\0\u0120\0\u0120\0\u0120\0\u0c90\0\u0120"+
    "\0\u0cc0\0\u0120\0\u0cf0\0\u0120";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[108];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\1\5\1\4\1\6\1\7\3\10\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\17\1\10\1\20"+
    "\1\21\1\22\1\23\2\10\1\24\1\10\1\25\1\26"+
    "\1\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36"+
    "\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46"+
    "\1\47\1\50\1\51\1\10\1\3\2\52\1\53\1\0"+
    "\54\52\63\0\1\4\60\0\1\10\1\54\23\10\22\0"+
    "\2\10\1\0\2\10\4\0\11\10\1\55\13\10\22\0"+
    "\2\10\1\0\2\10\4\0\25\10\22\0\2\10\1\0"+
    "\2\10\4\0\4\10\1\56\20\10\22\0\2\10\1\0"+
    "\2\10\4\0\20\10\1\57\4\10\22\0\2\10\1\0"+
    "\2\10\4\0\11\10\1\60\13\10\22\0\2\10\1\0"+
    "\2\10\4\0\1\10\1\61\23\10\22\0\2\10\1\0"+
    "\2\10\4\0\21\10\1\62\3\10\22\0\2\10\1\0"+
    "\2\10\4\0\7\10\1\63\15\10\22\0\2\10\1\0"+
    "\2\10\4\0\2\10\1\64\22\10\22\0\2\10\1\0"+
    "\2\10\4\0\22\10\1\65\2\10\22\0\2\10\1\0"+
    "\2\10\4\0\2\10\1\66\22\10\22\0\2\10\1\0"+
    "\2\10\4\0\2\10\1\67\22\10\22\0\2\10\1\0"+
    "\2\10\4\0\4\10\1\70\20\10\22\0\2\10\1\0"+
    "\2\10\4\0\1\10\1\71\23\10\22\0\2\10\1\0"+
    "\2\10\31\0\1\72\60\0\1\73\61\0\1\52\61\0"+
    "\1\74\57\0\1\75\57\0\1\76\57\0\1\77\73\0"+
    "\1\100\60\0\1\101\60\0\1\50\3\0\3\102\1\0"+
    "\54\102\3\0\1\103\60\0\2\10\1\104\3\10\1\105"+
    "\16\10\22\0\2\10\1\0\2\10\4\0\4\10\1\106"+
    "\3\10\1\107\14\10\22\0\2\10\1\0\2\10\4\0"+
    "\1\110\24\10\22\0\2\10\1\0\2\10\4\0\15\10"+
    "\1\111\7\10\22\0\2\10\1\0\2\10\4\0\12\10"+
    "\1\112\12\10\22\0\2\10\1\0\2\10\4\0\14\10"+
    "\1\113\10\10\22\0\2\10\1\0\2\10\4\0\6\10"+
    "\1\114\16\10\22\0\2\10\1\0\2\10\4\0\7\10"+
    "\1\115\15\10\22\0\2\10\1\0\2\10\4\0\6\10"+
    "\1\116\16\10\22\0\2\10\1\0\2\10\4\0\6\10"+
    "\1\117\16\10\22\0\2\10\1\0\2\10\4\0\21\10"+
    "\1\120\3\10\22\0\2\10\1\0\2\10\4\0\11\10"+
    "\1\121\13\10\22\0\2\10\1\0\2\10\55\0\1\122"+
    "\6\0\3\10\1\123\21\10\22\0\2\10\1\0\2\10"+
    "\4\0\7\10\1\124\15\10\22\0\2\10\1\0\2\10"+
    "\4\0\17\10\1\125\5\10\22\0\2\10\1\0\2\10"+
    "\4\0\12\10\1\126\12\10\22\0\2\10\1\0\2\10"+
    "\4\0\11\10\1\127\13\10\22\0\2\10\1\0\2\10"+
    "\4\0\11\10\1\130\13\10\22\0\2\10\1\0\2\10"+
    "\4\0\2\10\1\131\22\10\22\0\2\10\1\0\2\10"+
    "\4\0\10\10\1\132\3\10\1\133\10\10\22\0\2\10"+
    "\1\0\2\10\4\0\21\10\1\134\3\10\22\0\2\10"+
    "\1\0\2\10\4\0\17\10\1\135\5\10\22\0\2\10"+
    "\1\0\2\10\4\0\14\10\1\112\10\10\22\0\2\10"+
    "\1\0\2\10\4\0\4\10\1\136\20\10\22\0\2\10"+
    "\1\0\2\10\4\0\1\10\1\137\23\10\22\0\2\10"+
    "\1\0\2\10\4\0\10\10\1\140\14\10\22\0\2\10"+
    "\1\0\2\10\4\0\1\10\1\141\23\10\22\0\2\10"+
    "\1\0\2\10\4\0\7\10\1\142\15\10\22\0\2\10"+
    "\1\0\2\10\4\0\6\10\1\143\16\10\22\0\2\10"+
    "\1\0\2\10\4\0\10\10\1\144\14\10\22\0\2\10"+
    "\1\0\2\10\4\0\11\10\1\145\13\10\22\0\2\10"+
    "\1\0\2\10\4\0\24\10\1\146\22\0\2\10\1\0"+
    "\2\10\4\0\4\10\1\147\20\10\22\0\2\10\1\0"+
    "\2\10\4\0\7\10\1\150\15\10\22\0\2\10\1\0"+
    "\2\10\4\0\7\10\1\151\15\10\22\0\2\10\1\0"+
    "\2\10\4\0\5\10\1\152\17\10\22\0\2\10\1\0"+
    "\2\10\4\0\12\10\1\153\12\10\22\0\2\10\1\0"+
    "\2\10\4\0\11\10\1\154\13\10\22\0\2\10\1\0"+
    "\2\10";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3360];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\2\11\22\1\1\11\1\1\1\11\1\1\10\11"+
    "\7\1\1\11\17\1\10\11\1\0\1\11\16\1\1\11"+
    "\32\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[108];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */

	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}
	
	// ukljucivanje informacije o poziciji tokena
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}



  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Yylex(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Yylex(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 128) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 4: 
          { return new_symbol(sym.PLUS, yytext());
          }
        case 48: break;
        case 13: 
          { return new_symbol(sym.RPAREN, yytext());
          }
        case 49: break;
        case 11: 
          { return new_symbol(sym.COMMA, yytext());
          }
        case 50: break;
        case 34: 
          { return new_symbol(sym.NEW, yytext());
          }
        case 51: break;
        case 28: 
          { return new_symbol(sym.GTE, yytext());
          }
        case 52: break;
        case 15: 
          { return new_symbol(sym.RBRACE, yytext());
          }
        case 53: break;
        case 19: 
          { return new_symbol(sym.LT, yytext());
          }
        case 54: break;
        case 38: 
          { return new_symbol(sym.ELSE, yytext());
          }
        case 55: break;
        case 22: 
          { return new_symbol(sym.IF, yytext());
          }
        case 56: break;
        case 29: 
          { return new_symbol(sym.LTE, yytext());
          }
        case 57: break;
        case 9: 
          { return new_symbol(sym.ASSIGN, yytext());
          }
        case 58: break;
        case 7: 
          { return new_symbol(sym.DIV, yytext());
          }
        case 59: break;
        case 5: 
          { return new_symbol(sym.MINUS, yytext());
          }
        case 60: break;
        case 39: 
          { return new_symbol(sym.VOID, yytext());
          }
        case 61: break;
        case 32: 
          { yybegin(YYINITIAL);
          }
        case 62: break;
        case 42: 
          { return new_symbol(sym.CONST, yytext());
          }
        case 63: break;
        case 3: 
          { return new_symbol(sym.IDENT, yytext());
          }
        case 64: break;
        case 30: 
          { return new_symbol(sym.AND, yytext());
          }
        case 65: break;
        case 12: 
          { return new_symbol(sym.LPAREN, yytext());
          }
        case 66: break;
        case 35: 
          { return new_symbol(sym.CHAR, new Character (yytext().charAt(1)));
          }
        case 67: break;
        case 41: 
          { return new_symbol(sym.UNION, yytext());
          }
        case 68: break;
        case 1: 
          { System.err.println("Leksicka greska ("+yytext()+") na liniji "+(yyline+1) + " u koloni " + (yycolumn + 1) + "\n");
          }
        case 69: break;
        case 21: 
          { yybegin(COMMENT);
          }
        case 70: break;
        case 16: 
          { return new_symbol(sym.LBRACKET, yytext());
          }
        case 71: break;
        case 8: 
          { return new_symbol(sym.MOD, yytext());
          }
        case 72: break;
        case 6: 
          { return new_symbol(sym.MUL, yytext());
          }
        case 73: break;
        case 20: 
          { return new_symbol(sym.NUM, new Integer (yytext()));
          }
        case 74: break;
        case 44: 
          { return new_symbol(sym.BREAK, yytext());
          }
        case 75: break;
        case 18: 
          { return new_symbol(sym.GT, yytext());
          }
        case 76: break;
        case 14: 
          { return new_symbol(sym.LBRACE, yytext());
          }
        case 77: break;
        case 36: 
          { return new_symbol(sym.READ, yytext());
          }
        case 78: break;
        case 24: 
          { return new_symbol(sym.INC, yytext());
          }
        case 79: break;
        case 33: 
          { return new_symbol(sym.MAP, yytext());
          }
        case 80: break;
        case 43: 
          { return new_symbol(sym.WHILE, yytext());
          }
        case 81: break;
        case 37: 
          { return new_symbol(sym.BOOL, yytext().equals("true")? 1 : 0);
          }
        case 82: break;
        case 10: 
          { return new_symbol(sym.SEMI, yytext());
          }
        case 83: break;
        case 40: 
          { return new_symbol(sym.PRINT, yytext());
          }
        case 84: break;
        case 17: 
          { return new_symbol(sym.RBRACKET, yytext());
          }
        case 85: break;
        case 23: 
          { return new_symbol(sym.DO, yytext());
          }
        case 86: break;
        case 46: 
          { return new_symbol(sym.PROG, yytext());
          }
        case 87: break;
        case 27: 
          { return new_symbol(sym.NEQ, yytext());
          }
        case 88: break;
        case 45: 
          { return new_symbol(sym.RETURN, yytext());
          }
        case 89: break;
        case 26: 
          { return new_symbol(sym.EQ, yytext());
          }
        case 90: break;
        case 47: 
          { return new_symbol(sym.CONTINUE, yytext());
          }
        case 91: break;
        case 31: 
          { return new_symbol(sym.OR, yytext());
          }
        case 92: break;
        case 25: 
          { return new_symbol(sym.DEC, yytext());
          }
        case 93: break;
        case 2: 
          { 
          }
        case 94: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              {     return new_symbol(sym.EOF);
 }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
