// $ANTLR 3.0.1 D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g 2008-11-18 18:02:52

package org.eclipse.uml2.uml.resource.uml;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class UmlLexer extends Lexer {
    public static final int INTEGER=7;
    public static final int FLOAT=8;
    public static final int TEXT=5;
    public static final int Tokens=25;
    public static final int T24=24;
    public static final int EOF=-1;
    public static final int T23=23;
    public static final int T22=22;
    public static final int T21=21;
    public static final int T20=20;
    public static final int WS=10;
    public static final int LB=9;
    public static final int T11=11;
    public static final int T12=12;
    public static final int T13=13;
    public static final int T14=14;
    public static final int COMMENT=6;
    public static final int T15=15;
    public static final int T16=16;
    public static final int T17=17;
    public static final int QUOTED_34_34=4;
    public static final int T18=18;
    public static final int T19=19;

    	public java.util.List<RecognitionException> lexerExceptions  = new java.util.ArrayList<RecognitionException>();
    	public java.util.List<Integer> lexerExceptionsPosition       = new java.util.ArrayList<Integer>();

    	public void reportError(RecognitionException e) {
    		lexerExceptions.add(e);

    		lexerExceptionsPosition.add(((ANTLRStringStream)input).index());
    	}

    public UmlLexer() {;} 
    public UmlLexer(CharStream input) {
        super(input);
    }
    public String getGrammarFileName() { return "D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g"; }

    // $ANTLR start T11
    public final void mT11() throws RecognitionException {
        try {
            int _type = T11;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:17:5: ( 'StateMachine' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:17:7: 'StateMachine'
            {
            match("StateMachine"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T11

    // $ANTLR start T12
    public final void mT12() throws RecognitionException {
        try {
            int _type = T12;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:18:5: ( ';' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:18:7: ';'
            {
            match(';'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T12

    // $ANTLR start T13
    public final void mT13() throws RecognitionException {
        try {
            int _type = T13;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:19:5: ( 'state' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:19:7: 'state'
            {
            match("state"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T13

    // $ANTLR start T14
    public final void mT14() throws RecognitionException {
        try {
            int _type = T14;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:20:5: ( '{' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:20:7: '{'
            {
            match('{'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T14

    // $ANTLR start T15
    public final void mT15() throws RecognitionException {
        try {
            int _type = T15;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:21:5: ( 'entry' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:21:7: 'entry'
            {
            match("entry"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T15

    // $ANTLR start T16
    public final void mT16() throws RecognitionException {
        try {
            int _type = T16;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:22:5: ( ':' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:22:7: ':'
            {
            match(':'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T16

    // $ANTLR start T17
    public final void mT17() throws RecognitionException {
        try {
            int _type = T17;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:23:5: ( 'exit' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:23:7: 'exit'
            {
            match("exit"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T17

    // $ANTLR start T18
    public final void mT18() throws RecognitionException {
        try {
            int _type = T18;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:24:5: ( 'do' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:24:7: 'do'
            {
            match("do"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T18

    // $ANTLR start T19
    public final void mT19() throws RecognitionException {
        try {
            int _type = T19;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:25:5: ( '}' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:25:7: '}'
            {
            match('}'); 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T19

    // $ANTLR start T20
    public final void mT20() throws RecognitionException {
        try {
            int _type = T20;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:26:5: ( 'final' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:26:7: 'final'
            {
            match("final"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T20

    // $ANTLR start T21
    public final void mT21() throws RecognitionException {
        try {
            int _type = T21;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:27:5: ( 'transition' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:27:7: 'transition'
            {
            match("transition"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T21

    // $ANTLR start T22
    public final void mT22() throws RecognitionException {
        try {
            int _type = T22;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:28:5: ( 'from' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:28:7: 'from'
            {
            match("from"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T22

    // $ANTLR start T23
    public final void mT23() throws RecognitionException {
        try {
            int _type = T23;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:29:5: ( 'to' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:29:7: 'to'
            {
            match("to"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T23

    // $ANTLR start T24
    public final void mT24() throws RecognitionException {
        try {
            int _type = T24;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:30:5: ( 'when' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:30:7: 'when'
            {
            match("when"); 


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end T24

    // $ANTLR start COMMENT
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:713:1: ( '//' (~ ( '\\n' | '\\r' ) )* )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:714:2: '//' (~ ( '\\n' | '\\r' ) )*
            {
            match("//"); 

            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:714:6: (~ ( '\\n' | '\\r' ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='\u0000' && LA1_0<='\t')||(LA1_0>='\u000B' && LA1_0<='\f')||(LA1_0>='\u000E' && LA1_0<='\uFFFE')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:714:7: ~ ( '\\n' | '\\r' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

             channel=99; 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end COMMENT

    // $ANTLR start INTEGER
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:717:1: ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0=='-'||(LA4_0>='1' && LA4_0<='9')) ) {
                alt4=1;
            }
            else if ( (LA4_0=='0') ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("716:1: INTEGER : ( ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )* | '0' );", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:718:2: ( '-' )? ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:718:2: ( '-' )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0=='-') ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:718:3: '-'
                            {
                            match('-'); 

                            }
                            break;

                    }

                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:718:8: ( '1' .. '9' )
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:718:9: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }

                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:718:18: ( '0' .. '9' )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:718:19: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:718:30: '0'
                    {
                    match('0'); 
                     channel=99; 

                    }
                    break;

            }
            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end INTEGER

    // $ANTLR start FLOAT
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:721:1: ( ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+ )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:722:2: ( '-' )? ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' ) '.' ( '0' .. '9' )+
            {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:722:2: ( '-' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:722:3: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:722:8: ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>='1' && LA7_0<='9')) ) {
                alt7=1;
            }
            else if ( (LA7_0=='0') ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("722:8: ( ( '1' .. '9' ) ( '0' .. '9' )* | '0' )", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:722:9: ( '1' .. '9' ) ( '0' .. '9' )*
                    {
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:722:9: ( '1' .. '9' )
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:722:10: '1' .. '9'
                    {
                    matchRange('1','9'); 

                    }

                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:722:20: ( '0' .. '9' )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:722:21: '0' .. '9'
                    	    {
                    	    matchRange('0','9'); 

                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:722:34: '0'
                    {
                    match('0'); 

                    }
                    break;

            }

            match('.'); 
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:722:43: ( '0' .. '9' )+
            int cnt8=0;
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:722:44: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt8 >= 1 ) break loop8;
                        EarlyExitException eee =
                            new EarlyExitException(8, input);
                        throw eee;
                }
                cnt8++;
            } while (true);

             channel=99; 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end FLOAT

    // $ANTLR start LB
    public final void mLB() throws RecognitionException {
        try {
            int _type = LB;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:725:1: ( ( '\\r\\n' | '\\r' | '\\n' ) )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:726:2: ( '\\r\\n' | '\\r' | '\\n' )
            {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:726:2: ( '\\r\\n' | '\\r' | '\\n' )
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\r') ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1=='\n') ) {
                    alt9=1;
                }
                else {
                    alt9=2;}
            }
            else if ( (LA9_0=='\n') ) {
                alt9=3;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("726:2: ( '\\r\\n' | '\\r' | '\\n' )", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:726:3: '\\r\\n'
                    {
                    match("\r\n"); 


                    }
                    break;
                case 2 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:726:12: '\\r'
                    {
                    match('\r'); 

                    }
                    break;
                case 3 :
                    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:726:19: '\\n'
                    {
                    match('\n'); 

                    }
                    break;

            }

             channel=99; 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end LB

    // $ANTLR start WS
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:729:1: ( ( ' ' | '\\t' | '\\f' ) )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:730:2: ( ' ' | '\\t' | '\\f' )
            {
            if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse =
                    new MismatchedSetException(null,input);
                recover(mse);    throw mse;
            }

             channel=99; 

            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end WS

    // $ANTLR start TEXT
    public final void mTEXT() throws RecognitionException {
        try {
            int _type = TEXT;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:733:1: ( ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+ )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:734:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:734:2: ( 'A' .. 'Z' | 'a' .. 'z' | '0' .. '9' | '_' | '-' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='-'||(LA10_0>='0' && LA10_0<='9')||(LA10_0>='A' && LA10_0<='Z')||LA10_0=='_'||(LA10_0>='a' && LA10_0<='z')) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end TEXT

    // $ANTLR start QUOTED_34_34
    public final void mQUOTED_34_34() throws RecognitionException {
        try {
            int _type = QUOTED_34_34;
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:737:1: ( ( '\"' ) (~ ( '\"' ) | ( '\\\\' '\"' ) )* ( '\"' ) )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:738:2: ( '\"' ) (~ ( '\"' ) | ( '\\\\' '\"' ) )* ( '\"' )
            {
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:738:2: ( '\"' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:738:3: '\"'
            {
            match('\"'); 

            }

            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:738:7: (~ ( '\"' ) | ( '\\\\' '\"' ) )*
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='\\') ) {
                    int LA11_2 = input.LA(2);

                    if ( (LA11_2=='\"') ) {
                        int LA11_4 = input.LA(3);

                        if ( ((LA11_4>='\u0000' && LA11_4<='\uFFFE')) ) {
                            alt11=2;
                        }

                        else {
                            alt11=1;
                        }

                    }
                    else if ( ((LA11_2>='\u0000' && LA11_2<='!')||(LA11_2>='#' && LA11_2<='\uFFFE')) ) {
                        alt11=1;
                    }


                }
                else if ( ((LA11_0>='\u0000' && LA11_0<='!')||(LA11_0>='#' && LA11_0<='[')||(LA11_0>=']' && LA11_0<='\uFFFE')) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:738:8: ~ ( '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='\uFFFE') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse =
            	            new MismatchedSetException(null,input);
            	        recover(mse);    throw mse;
            	    }


            	    }
            	    break;
            	case 2 :
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:738:15: ( '\\\\' '\"' )
            	    {
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:738:15: ( '\\\\' '\"' )
            	    // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:738:16: '\\\\' '\"'
            	    {
            	    match('\\'); 
            	    match('\"'); 

            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:738:26: ( '\"' )
            // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:738:27: '\"'
            {
            match('\"'); 

            }


            }

            this.type = _type;
        }
        finally {
        }
    }
    // $ANTLR end QUOTED_34_34

    public void mTokens() throws RecognitionException {
        // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:1:8: ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | COMMENT | INTEGER | FLOAT | LB | WS | TEXT | QUOTED_34_34 )
        int alt12=21;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:1:10: T11
                {
                mT11(); 

                }
                break;
            case 2 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:1:14: T12
                {
                mT12(); 

                }
                break;
            case 3 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:1:18: T13
                {
                mT13(); 

                }
                break;
            case 4 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:1:22: T14
                {
                mT14(); 

                }
                break;
            case 5 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:1:26: T15
                {
                mT15(); 

                }
                break;
            case 6 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:1:30: T16
                {
                mT16(); 

                }
                break;
            case 7 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:1:34: T17
                {
                mT17(); 

                }
                break;
            case 8 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:1:38: T18
                {
                mT18(); 

                }
                break;
            case 9 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:1:42: T19
                {
                mT19(); 

                }
                break;
            case 10 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:1:46: T20
                {
                mT20(); 

                }
                break;
            case 11 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:1:50: T21
                {
                mT21(); 

                }
                break;
            case 12 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:1:54: T22
                {
                mT22(); 

                }
                break;
            case 13 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:1:58: T23
                {
                mT23(); 

                }
                break;
            case 14 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:1:62: T24
                {
                mT24(); 

                }
                break;
            case 15 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:1:66: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 16 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:1:74: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 17 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:1:82: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 18 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:1:88: LB
                {
                mLB(); 

                }
                break;
            case 19 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:1:91: WS
                {
                mWS(); 

                }
                break;
            case 20 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:1:94: TEXT
                {
                mTEXT(); 

                }
                break;
            case 21 :
                // D:\\userdata\\work\\ete.examples\\EMFTextEdit Languages\\org.eclipse.uml2.uml.resource.uml\\src\\org\\eclipse\\uml2\\uml\\resource\\uml\\Uml.g:1:99: QUOTED_34_34
                {
                mQUOTED_34_34(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\1\22\1\uffff\1\22\1\uffff\1\22\1\uffff\1\22\1\uffff\3"+
        "\22\1\uffff\1\22\2\41\4\uffff\4\22\1\46\3\22\1\52\2\22\1\41\2\uffff"+
        "\4\22\1\uffff\3\22\1\uffff\4\22\1\67\1\70\2\22\1\73\1\22\1\75\1"+
        "\76\2\uffff\1\77\1\22\1\uffff\1\22\3\uffff\10\22\1\112\1\22\1\uffff"+
        "\1\114\1\uffff";
    static final String DFA12_eofS =
        "\115\uffff";
    static final String DFA12_minS =
        "\1\11\1\164\1\uffff\1\164\1\uffff\1\156\1\uffff\1\157\1\uffff\1"+
        "\151\1\157\1\150\1\uffff\1\60\2\55\4\uffff\2\141\1\164\1\151\1\55"+
        "\1\157\1\156\1\141\1\55\1\145\1\56\1\55\2\uffff\2\164\1\162\1\164"+
        "\1\uffff\1\155\1\141\1\156\1\uffff\1\156\2\145\1\171\2\55\1\154"+
        "\1\163\1\55\1\115\2\55\2\uffff\1\55\1\151\1\uffff\1\141\3\uffff"+
        "\1\164\1\143\1\151\1\150\1\157\1\151\2\156\1\55\1\145\1\uffff\1"+
        "\55\1\uffff";
    static final String DFA12_maxS =
        "\1\175\1\164\1\uffff\1\164\1\uffff\1\170\1\uffff\1\157\1\uffff"+
        "\2\162\1\150\1\uffff\1\71\2\172\4\uffff\2\141\1\164\1\151\1\172"+
        "\1\157\1\156\1\141\1\172\1\145\1\56\1\172\2\uffff\2\164\1\162\1"+
        "\164\1\uffff\1\155\1\141\1\156\1\uffff\1\156\2\145\1\171\2\172\1"+
        "\154\1\163\1\172\1\115\2\172\2\uffff\1\172\1\151\1\uffff\1\141\3"+
        "\uffff\1\164\1\143\1\151\1\150\1\157\1\151\2\156\1\172\1\145\1\uffff"+
        "\1\172\1\uffff";
    static final String DFA12_acceptS =
        "\2\uffff\1\2\1\uffff\1\4\1\uffff\1\6\1\uffff\1\11\3\uffff\1\17"+
        "\3\uffff\1\22\1\23\1\24\1\25\14\uffff\1\21\1\20\4\uffff\1\10\3\uffff"+
        "\1\15\14\uffff\1\7\1\14\2\uffff\1\16\1\uffff\1\3\1\5\1\12\12\uffff"+
        "\1\13\1\uffff\1\1";
    static final String DFA12_specialS =
        "\115\uffff}>";
    static final String[] DFA12_transitionS = {
            "\1\21\1\20\1\uffff\1\21\1\20\22\uffff\1\21\1\uffff\1\23\12"+
            "\uffff\1\15\1\uffff\1\14\1\17\11\16\1\6\1\2\5\uffff\22\22\1"+
            "\1\7\22\4\uffff\1\22\1\uffff\3\22\1\7\1\5\1\11\14\22\1\3\1\12"+
            "\2\22\1\13\3\22\1\4\1\uffff\1\10",
            "\1\24",
            "",
            "\1\25",
            "",
            "\1\26\11\uffff\1\27",
            "",
            "\1\30",
            "",
            "\1\32\10\uffff\1\31",
            "\1\34\2\uffff\1\33",
            "\1\35",
            "",
            "\1\36\11\16",
            "\1\22\1\40\1\uffff\12\37\7\uffff\32\22\4\uffff\1\22\1\uffff"+
            "\32\22",
            "\1\22\1\40\1\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff"+
            "\32\22",
            "",
            "",
            "",
            "",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\45",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            "\1\47",
            "\1\50",
            "\1\51",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            "\1\53",
            "\1\40",
            "\1\22\1\40\1\uffff\12\37\7\uffff\32\22\4\uffff\1\22\1\uffff"+
            "\32\22",
            "",
            "",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57",
            "",
            "\1\60",
            "\1\61",
            "\1\62",
            "",
            "\1\63",
            "\1\64",
            "\1\65",
            "\1\66",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            "\1\71",
            "\1\72",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            "\1\74",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            "",
            "",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            "\1\100",
            "",
            "\1\101",
            "",
            "",
            "",
            "\1\102",
            "\1\103",
            "\1\104",
            "\1\105",
            "\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            "\1\113",
            "",
            "\1\22\2\uffff\12\22\7\uffff\32\22\4\uffff\1\22\1\uffff\32"+
            "\22",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T11 | T12 | T13 | T14 | T15 | T16 | T17 | T18 | T19 | T20 | T21 | T22 | T23 | T24 | COMMENT | INTEGER | FLOAT | LB | WS | TEXT | QUOTED_34_34 );";
        }
    }
 

}