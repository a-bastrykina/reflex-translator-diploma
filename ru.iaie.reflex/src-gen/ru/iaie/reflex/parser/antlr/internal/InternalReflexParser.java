package ru.iaie.reflex.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import ru.iaie.reflex.services.ReflexGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalReflexParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INTEGER", "RULE_TIME", "RULE_STRING", "RULE_FLOAT", "RULE_BOOL_LITERAL", "RULE_BIT_AND", "RULE_BIT_XOR", "RULE_BIT_OR", "RULE_LOGICAL_AND", "RULE_LOGICAL_OR", "RULE_SIGN", "RULE_HEX", "RULE_OCTAL", "RULE_DECIMAL", "RULE_LONG", "RULE_UNSIGNED", "RULE_DEC_FLOAT", "RULE_HEX_FLOAT", "RULE_DEC_SEQUENCE", "RULE_EXPONENT", "RULE_FLOAT_SUFFIX", "RULE_HEX_SEQUENCE", "RULE_BIN_EXPONENT", "RULE_HEX_PREFIX", "RULE_DAY", "RULE_HOUR", "RULE_MINUTE", "RULE_SECOND", "RULE_MILLISECOND", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'['", "']'", "'program'", "'{'", "'}'", "'clock'", "';'", "'process'", "'state'", "'looped'", "':'", "'.'", "'shared'", "','", "'from'", "'='", "'timeout'", "'('", "')'", "'const'", "'enum'", "'if'", "'else'", "'switch'", "'case'", "'default'", "'break'", "'start'", "'stop'", "'error'", "'restart'", "'reset'", "'timer'", "'set'", "'next'", "'in'", "'input'", "'output'", "'active'", "'inactive'", "'++'", "'--'", "'*='", "'/='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'+'", "'-'", "'~'", "'!'", "'<'", "'>'", "'=<'", "'>='", "'=='", "'!='", "'>>'", "'<<'", "'*'", "'/'", "'%'", "'void'", "'float'", "'double'", "'int8'", "'uint8'", "'int16'", "'uint16'", "'int32'", "'uint32'", "'int64'", "'uint64'", "'bool'", "'time'"
    };
    public static final int RULE_HEX=16;
    public static final int T__50=50;
    public static final int RULE_SIGN=15;
    public static final int RULE_DEC_SEQUENCE=23;
    public static final int RULE_MINUTE=31;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int RULE_TIME=6;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_HEX_FLOAT=22;
    public static final int RULE_INT=34;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=35;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__39=39;
    public static final int RULE_MILLISECOND=33;
    public static final int RULE_HEX_SEQUENCE=26;
    public static final int RULE_HOUR=30;
    public static final int RULE_UNSIGNED=20;
    public static final int RULE_BOOL_LITERAL=9;
    public static final int RULE_BIN_EXPONENT=27;
    public static final int RULE_LOGICAL_AND=13;
    public static final int RULE_EXPONENT=24;
    public static final int T__48=48;
    public static final int RULE_DEC_FLOAT=21;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_FLOAT=8;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int RULE_BIT_AND=10;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int RULE_DAY=29;
    public static final int T__90=90;
    public static final int RULE_OCTAL=17;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int RULE_DECIMAL=18;
    public static final int RULE_SECOND=32;
    public static final int RULE_LOGICAL_OR=14;
    public static final int RULE_FLOAT_SUFFIX=25;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=7;
    public static final int RULE_SL_COMMENT=36;
    public static final int RULE_HEX_PREFIX=28;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=37;
    public static final int RULE_ANY_OTHER=38;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int RULE_BIT_XOR=11;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int RULE_BIT_OR=12;
    public static final int RULE_LONG=19;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int RULE_INTEGER=5;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalReflexParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalReflexParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalReflexParser.tokenNames; }
    public String getGrammarFileName() { return "InternalReflex.g"; }



     	private ReflexGrammarAccess grammarAccess;

        public InternalReflexParser(TokenStream input, ReflexGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Program";
       	}

       	@Override
       	protected ReflexGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleProgram"
    // InternalReflex.g:65:1: entryRuleProgram returns [EObject current=null] : iv_ruleProgram= ruleProgram EOF ;
    public final EObject entryRuleProgram() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgram = null;


        try {
            // InternalReflex.g:65:48: (iv_ruleProgram= ruleProgram EOF )
            // InternalReflex.g:66:2: iv_ruleProgram= ruleProgram EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProgramRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProgram=ruleProgram();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProgram; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgram"


    // $ANTLR start "ruleProgram"
    // InternalReflex.g:72:1: ruleProgram returns [EObject current=null] : ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'program' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( (lv_clock_6_0= ruleClockDefinition ) ) ( ( (lv_consts_7_0= ruleConst ) ) | ( (lv_enums_8_0= ruleEnum ) ) | ( (lv_functions_9_0= ruleFunction ) ) | ( (lv_globalVars_10_0= ruleGlobalVariable ) ) | ( (lv_ports_11_0= rulePort ) ) | ( (lv_processes_12_0= ruleProcess ) ) )* otherlv_13= '}' ) ;
    public final EObject ruleProgram() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        Token otherlv_13=null;
        EObject lv_annotations_1_0 = null;

        EObject lv_clock_6_0 = null;

        EObject lv_consts_7_0 = null;

        EObject lv_enums_8_0 = null;

        EObject lv_functions_9_0 = null;

        EObject lv_globalVars_10_0 = null;

        EObject lv_ports_11_0 = null;

        EObject lv_processes_12_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:78:2: ( ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'program' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( (lv_clock_6_0= ruleClockDefinition ) ) ( ( (lv_consts_7_0= ruleConst ) ) | ( (lv_enums_8_0= ruleEnum ) ) | ( (lv_functions_9_0= ruleFunction ) ) | ( (lv_globalVars_10_0= ruleGlobalVariable ) ) | ( (lv_ports_11_0= rulePort ) ) | ( (lv_processes_12_0= ruleProcess ) ) )* otherlv_13= '}' ) )
            // InternalReflex.g:79:2: ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'program' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( (lv_clock_6_0= ruleClockDefinition ) ) ( ( (lv_consts_7_0= ruleConst ) ) | ( (lv_enums_8_0= ruleEnum ) ) | ( (lv_functions_9_0= ruleFunction ) ) | ( (lv_globalVars_10_0= ruleGlobalVariable ) ) | ( (lv_ports_11_0= rulePort ) ) | ( (lv_processes_12_0= ruleProcess ) ) )* otherlv_13= '}' )
            {
            // InternalReflex.g:79:2: ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'program' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( (lv_clock_6_0= ruleClockDefinition ) ) ( ( (lv_consts_7_0= ruleConst ) ) | ( (lv_enums_8_0= ruleEnum ) ) | ( (lv_functions_9_0= ruleFunction ) ) | ( (lv_globalVars_10_0= ruleGlobalVariable ) ) | ( (lv_ports_11_0= rulePort ) ) | ( (lv_processes_12_0= ruleProcess ) ) )* otherlv_13= '}' )
            // InternalReflex.g:80:3: (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'program' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( (lv_clock_6_0= ruleClockDefinition ) ) ( ( (lv_consts_7_0= ruleConst ) ) | ( (lv_enums_8_0= ruleEnum ) ) | ( (lv_functions_9_0= ruleFunction ) ) | ( (lv_globalVars_10_0= ruleGlobalVariable ) ) | ( (lv_ports_11_0= rulePort ) ) | ( (lv_processes_12_0= ruleProcess ) ) )* otherlv_13= '}'
            {
            // InternalReflex.g:80:3: (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==39) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalReflex.g:81:4: otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']'
            	    {
            	    otherlv_0=(Token)match(input,39,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_0, grammarAccess.getProgramAccess().getLeftSquareBracketKeyword_0_0());
            	      			
            	    }
            	    // InternalReflex.g:85:4: ( (lv_annotations_1_0= ruleAnnotation ) )
            	    // InternalReflex.g:86:5: (lv_annotations_1_0= ruleAnnotation )
            	    {
            	    // InternalReflex.g:86:5: (lv_annotations_1_0= ruleAnnotation )
            	    // InternalReflex.g:87:6: lv_annotations_1_0= ruleAnnotation
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getAnnotationsAnnotationParserRuleCall_0_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_annotations_1_0=ruleAnnotation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"annotations",
            	      							lv_annotations_1_0,
            	      							"ru.iaie.reflex.Reflex.Annotation");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    otherlv_2=(Token)match(input,40,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getProgramAccess().getRightSquareBracketKeyword_0_2());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_3=(Token)match(input,41,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getProgramAccess().getProgramKeyword_1());
              		
            }
            // InternalReflex.g:113:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalReflex.g:114:4: (lv_name_4_0= RULE_ID )
            {
            // InternalReflex.g:114:4: (lv_name_4_0= RULE_ID )
            // InternalReflex.g:115:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_4_0, grammarAccess.getProgramAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getProgramRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_4_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_5=(Token)match(input,42,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getProgramAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalReflex.g:135:3: ( (lv_clock_6_0= ruleClockDefinition ) )
            // InternalReflex.g:136:4: (lv_clock_6_0= ruleClockDefinition )
            {
            // InternalReflex.g:136:4: (lv_clock_6_0= ruleClockDefinition )
            // InternalReflex.g:137:5: lv_clock_6_0= ruleClockDefinition
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getProgramAccess().getClockClockDefinitionParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_8);
            lv_clock_6_0=ruleClockDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getProgramRule());
              					}
              					set(
              						current,
              						"clock",
              						lv_clock_6_0,
              						"ru.iaie.reflex.Reflex.ClockDefinition");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:154:3: ( ( (lv_consts_7_0= ruleConst ) ) | ( (lv_enums_8_0= ruleEnum ) ) | ( (lv_functions_9_0= ruleFunction ) ) | ( (lv_globalVars_10_0= ruleGlobalVariable ) ) | ( (lv_ports_11_0= rulePort ) ) | ( (lv_processes_12_0= ruleProcess ) ) )*
            loop2:
            do {
                int alt2=7;
                alt2 = dfa2.predict(input);
                switch (alt2) {
            	case 1 :
            	    // InternalReflex.g:155:4: ( (lv_consts_7_0= ruleConst ) )
            	    {
            	    // InternalReflex.g:155:4: ( (lv_consts_7_0= ruleConst ) )
            	    // InternalReflex.g:156:5: (lv_consts_7_0= ruleConst )
            	    {
            	    // InternalReflex.g:156:5: (lv_consts_7_0= ruleConst )
            	    // InternalReflex.g:157:6: lv_consts_7_0= ruleConst
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getConstsConstParserRuleCall_5_0_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_consts_7_0=ruleConst();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"consts",
            	      							lv_consts_7_0,
            	      							"ru.iaie.reflex.Reflex.Const");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalReflex.g:175:4: ( (lv_enums_8_0= ruleEnum ) )
            	    {
            	    // InternalReflex.g:175:4: ( (lv_enums_8_0= ruleEnum ) )
            	    // InternalReflex.g:176:5: (lv_enums_8_0= ruleEnum )
            	    {
            	    // InternalReflex.g:176:5: (lv_enums_8_0= ruleEnum )
            	    // InternalReflex.g:177:6: lv_enums_8_0= ruleEnum
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getEnumsEnumParserRuleCall_5_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_enums_8_0=ruleEnum();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"enums",
            	      							lv_enums_8_0,
            	      							"ru.iaie.reflex.Reflex.Enum");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalReflex.g:195:4: ( (lv_functions_9_0= ruleFunction ) )
            	    {
            	    // InternalReflex.g:195:4: ( (lv_functions_9_0= ruleFunction ) )
            	    // InternalReflex.g:196:5: (lv_functions_9_0= ruleFunction )
            	    {
            	    // InternalReflex.g:196:5: (lv_functions_9_0= ruleFunction )
            	    // InternalReflex.g:197:6: lv_functions_9_0= ruleFunction
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getFunctionsFunctionParserRuleCall_5_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_functions_9_0=ruleFunction();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"functions",
            	      							lv_functions_9_0,
            	      							"ru.iaie.reflex.Reflex.Function");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalReflex.g:215:4: ( (lv_globalVars_10_0= ruleGlobalVariable ) )
            	    {
            	    // InternalReflex.g:215:4: ( (lv_globalVars_10_0= ruleGlobalVariable ) )
            	    // InternalReflex.g:216:5: (lv_globalVars_10_0= ruleGlobalVariable )
            	    {
            	    // InternalReflex.g:216:5: (lv_globalVars_10_0= ruleGlobalVariable )
            	    // InternalReflex.g:217:6: lv_globalVars_10_0= ruleGlobalVariable
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getGlobalVarsGlobalVariableParserRuleCall_5_3_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_globalVars_10_0=ruleGlobalVariable();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"globalVars",
            	      							lv_globalVars_10_0,
            	      							"ru.iaie.reflex.Reflex.GlobalVariable");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalReflex.g:235:4: ( (lv_ports_11_0= rulePort ) )
            	    {
            	    // InternalReflex.g:235:4: ( (lv_ports_11_0= rulePort ) )
            	    // InternalReflex.g:236:5: (lv_ports_11_0= rulePort )
            	    {
            	    // InternalReflex.g:236:5: (lv_ports_11_0= rulePort )
            	    // InternalReflex.g:237:6: lv_ports_11_0= rulePort
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getPortsPortParserRuleCall_5_4_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_ports_11_0=rulePort();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"ports",
            	      							lv_ports_11_0,
            	      							"ru.iaie.reflex.Reflex.Port");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalReflex.g:255:4: ( (lv_processes_12_0= ruleProcess ) )
            	    {
            	    // InternalReflex.g:255:4: ( (lv_processes_12_0= ruleProcess ) )
            	    // InternalReflex.g:256:5: (lv_processes_12_0= ruleProcess )
            	    {
            	    // InternalReflex.g:256:5: (lv_processes_12_0= ruleProcess )
            	    // InternalReflex.g:257:6: lv_processes_12_0= ruleProcess
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getProcessesProcessParserRuleCall_5_5_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_processes_12_0=ruleProcess();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"processes",
            	      							lv_processes_12_0,
            	      							"ru.iaie.reflex.Reflex.Process");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            otherlv_13=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_13, grammarAccess.getProgramAccess().getRightCurlyBracketKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgram"


    // $ANTLR start "entryRuleClockDefinition"
    // InternalReflex.g:283:1: entryRuleClockDefinition returns [EObject current=null] : iv_ruleClockDefinition= ruleClockDefinition EOF ;
    public final EObject entryRuleClockDefinition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClockDefinition = null;


        try {
            // InternalReflex.g:283:56: (iv_ruleClockDefinition= ruleClockDefinition EOF )
            // InternalReflex.g:284:2: iv_ruleClockDefinition= ruleClockDefinition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getClockDefinitionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleClockDefinition=ruleClockDefinition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleClockDefinition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleClockDefinition"


    // $ANTLR start "ruleClockDefinition"
    // InternalReflex.g:290:1: ruleClockDefinition returns [EObject current=null] : (otherlv_0= 'clock' ( ( (lv_intValue_1_0= RULE_INTEGER ) ) | ( (lv_timeValue_2_0= RULE_TIME ) ) ) otherlv_3= ';' ) ;
    public final EObject ruleClockDefinition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_intValue_1_0=null;
        Token lv_timeValue_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalReflex.g:296:2: ( (otherlv_0= 'clock' ( ( (lv_intValue_1_0= RULE_INTEGER ) ) | ( (lv_timeValue_2_0= RULE_TIME ) ) ) otherlv_3= ';' ) )
            // InternalReflex.g:297:2: (otherlv_0= 'clock' ( ( (lv_intValue_1_0= RULE_INTEGER ) ) | ( (lv_timeValue_2_0= RULE_TIME ) ) ) otherlv_3= ';' )
            {
            // InternalReflex.g:297:2: (otherlv_0= 'clock' ( ( (lv_intValue_1_0= RULE_INTEGER ) ) | ( (lv_timeValue_2_0= RULE_TIME ) ) ) otherlv_3= ';' )
            // InternalReflex.g:298:3: otherlv_0= 'clock' ( ( (lv_intValue_1_0= RULE_INTEGER ) ) | ( (lv_timeValue_2_0= RULE_TIME ) ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,44,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getClockDefinitionAccess().getClockKeyword_0());
              		
            }
            // InternalReflex.g:302:3: ( ( (lv_intValue_1_0= RULE_INTEGER ) ) | ( (lv_timeValue_2_0= RULE_TIME ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_INTEGER) ) {
                alt3=1;
            }
            else if ( (LA3_0==RULE_TIME) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // InternalReflex.g:303:4: ( (lv_intValue_1_0= RULE_INTEGER ) )
                    {
                    // InternalReflex.g:303:4: ( (lv_intValue_1_0= RULE_INTEGER ) )
                    // InternalReflex.g:304:5: (lv_intValue_1_0= RULE_INTEGER )
                    {
                    // InternalReflex.g:304:5: (lv_intValue_1_0= RULE_INTEGER )
                    // InternalReflex.g:305:6: lv_intValue_1_0= RULE_INTEGER
                    {
                    lv_intValue_1_0=(Token)match(input,RULE_INTEGER,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_intValue_1_0, grammarAccess.getClockDefinitionAccess().getIntValueINTEGERTerminalRuleCall_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getClockDefinitionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"intValue",
                      							lv_intValue_1_0,
                      							"ru.iaie.reflex.Reflex.INTEGER");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:322:4: ( (lv_timeValue_2_0= RULE_TIME ) )
                    {
                    // InternalReflex.g:322:4: ( (lv_timeValue_2_0= RULE_TIME ) )
                    // InternalReflex.g:323:5: (lv_timeValue_2_0= RULE_TIME )
                    {
                    // InternalReflex.g:323:5: (lv_timeValue_2_0= RULE_TIME )
                    // InternalReflex.g:324:6: lv_timeValue_2_0= RULE_TIME
                    {
                    lv_timeValue_2_0=(Token)match(input,RULE_TIME,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_timeValue_2_0, grammarAccess.getClockDefinitionAccess().getTimeValueTIMETerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getClockDefinitionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"timeValue",
                      							lv_timeValue_2_0,
                      							"ru.iaie.reflex.Reflex.TIME");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getClockDefinitionAccess().getSemicolonKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleClockDefinition"


    // $ANTLR start "entryRuleProcess"
    // InternalReflex.g:349:1: entryRuleProcess returns [EObject current=null] : iv_ruleProcess= ruleProcess EOF ;
    public final EObject entryRuleProcess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcess = null;


        try {
            // InternalReflex.g:349:48: (iv_ruleProcess= ruleProcess EOF )
            // InternalReflex.g:350:2: iv_ruleProcess= ruleProcess EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProcessRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProcess=ruleProcess();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProcess; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProcess"


    // $ANTLR start "ruleProcess"
    // InternalReflex.g:356:1: ruleProcess returns [EObject current=null] : ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'process' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( ( ( (lv_imports_6_0= ruleImportedVariableList ) ) | ( (lv_variables_7_0= ruleProcessVariable ) ) ) otherlv_8= ';' )* ( (lv_states_9_0= ruleState ) )* otherlv_10= '}' ) ;
    public final EObject ruleProcess() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        EObject lv_annotations_1_0 = null;

        EObject lv_imports_6_0 = null;

        EObject lv_variables_7_0 = null;

        EObject lv_states_9_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:362:2: ( ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'process' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( ( ( (lv_imports_6_0= ruleImportedVariableList ) ) | ( (lv_variables_7_0= ruleProcessVariable ) ) ) otherlv_8= ';' )* ( (lv_states_9_0= ruleState ) )* otherlv_10= '}' ) )
            // InternalReflex.g:363:2: ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'process' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( ( ( (lv_imports_6_0= ruleImportedVariableList ) ) | ( (lv_variables_7_0= ruleProcessVariable ) ) ) otherlv_8= ';' )* ( (lv_states_9_0= ruleState ) )* otherlv_10= '}' )
            {
            // InternalReflex.g:363:2: ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'process' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( ( ( (lv_imports_6_0= ruleImportedVariableList ) ) | ( (lv_variables_7_0= ruleProcessVariable ) ) ) otherlv_8= ';' )* ( (lv_states_9_0= ruleState ) )* otherlv_10= '}' )
            // InternalReflex.g:364:3: (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'process' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( ( ( (lv_imports_6_0= ruleImportedVariableList ) ) | ( (lv_variables_7_0= ruleProcessVariable ) ) ) otherlv_8= ';' )* ( (lv_states_9_0= ruleState ) )* otherlv_10= '}'
            {
            // InternalReflex.g:364:3: (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==39) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalReflex.g:365:4: otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']'
            	    {
            	    otherlv_0=(Token)match(input,39,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_0, grammarAccess.getProcessAccess().getLeftSquareBracketKeyword_0_0());
            	      			
            	    }
            	    // InternalReflex.g:369:4: ( (lv_annotations_1_0= ruleAnnotation ) )
            	    // InternalReflex.g:370:5: (lv_annotations_1_0= ruleAnnotation )
            	    {
            	    // InternalReflex.g:370:5: (lv_annotations_1_0= ruleAnnotation )
            	    // InternalReflex.g:371:6: lv_annotations_1_0= ruleAnnotation
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProcessAccess().getAnnotationsAnnotationParserRuleCall_0_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_annotations_1_0=ruleAnnotation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProcessRule());
            	      						}
            	      						add(
            	      							current,
            	      							"annotations",
            	      							lv_annotations_1_0,
            	      							"ru.iaie.reflex.Reflex.Annotation");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    otherlv_2=(Token)match(input,40,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getProcessAccess().getRightSquareBracketKeyword_0_2());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_3=(Token)match(input,46,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getProcessAccess().getProcessKeyword_1());
              		
            }
            // InternalReflex.g:397:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalReflex.g:398:4: (lv_name_4_0= RULE_ID )
            {
            // InternalReflex.g:398:4: (lv_name_4_0= RULE_ID )
            // InternalReflex.g:399:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_4_0, grammarAccess.getProcessAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getProcessRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_4_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_5=(Token)match(input,42,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getProcessAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalReflex.g:419:3: ( ( ( (lv_imports_6_0= ruleImportedVariableList ) ) | ( (lv_variables_7_0= ruleProcessVariable ) ) ) otherlv_8= ';' )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==51||(LA6_0>=105 && LA6_0<=117)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalReflex.g:420:4: ( ( (lv_imports_6_0= ruleImportedVariableList ) ) | ( (lv_variables_7_0= ruleProcessVariable ) ) ) otherlv_8= ';'
            	    {
            	    // InternalReflex.g:420:4: ( ( (lv_imports_6_0= ruleImportedVariableList ) ) | ( (lv_variables_7_0= ruleProcessVariable ) ) )
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==51) ) {
            	        alt5=1;
            	    }
            	    else if ( ((LA5_0>=105 && LA5_0<=117)) ) {
            	        alt5=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 5, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // InternalReflex.g:421:5: ( (lv_imports_6_0= ruleImportedVariableList ) )
            	            {
            	            // InternalReflex.g:421:5: ( (lv_imports_6_0= ruleImportedVariableList ) )
            	            // InternalReflex.g:422:6: (lv_imports_6_0= ruleImportedVariableList )
            	            {
            	            // InternalReflex.g:422:6: (lv_imports_6_0= ruleImportedVariableList )
            	            // InternalReflex.g:423:7: lv_imports_6_0= ruleImportedVariableList
            	            {
            	            if ( state.backtracking==0 ) {

            	              							newCompositeNode(grammarAccess.getProcessAccess().getImportsImportedVariableListParserRuleCall_4_0_0_0());
            	              						
            	            }
            	            pushFollow(FOLLOW_10);
            	            lv_imports_6_0=ruleImportedVariableList();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElementForParent(grammarAccess.getProcessRule());
            	              							}
            	              							add(
            	              								current,
            	              								"imports",
            	              								lv_imports_6_0,
            	              								"ru.iaie.reflex.Reflex.ImportedVariableList");
            	              							afterParserOrEnumRuleCall();
            	              						
            	            }

            	            }


            	            }


            	            }
            	            break;
            	        case 2 :
            	            // InternalReflex.g:441:5: ( (lv_variables_7_0= ruleProcessVariable ) )
            	            {
            	            // InternalReflex.g:441:5: ( (lv_variables_7_0= ruleProcessVariable ) )
            	            // InternalReflex.g:442:6: (lv_variables_7_0= ruleProcessVariable )
            	            {
            	            // InternalReflex.g:442:6: (lv_variables_7_0= ruleProcessVariable )
            	            // InternalReflex.g:443:7: lv_variables_7_0= ruleProcessVariable
            	            {
            	            if ( state.backtracking==0 ) {

            	              							newCompositeNode(grammarAccess.getProcessAccess().getVariablesProcessVariableParserRuleCall_4_0_1_0());
            	              						
            	            }
            	            pushFollow(FOLLOW_10);
            	            lv_variables_7_0=ruleProcessVariable();

            	            state._fsp--;
            	            if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElementForParent(grammarAccess.getProcessRule());
            	              							}
            	              							add(
            	              								current,
            	              								"variables",
            	              								lv_variables_7_0,
            	              								"ru.iaie.reflex.Reflex.ProcessVariable");
            	              							afterParserOrEnumRuleCall();
            	              						
            	            }

            	            }


            	            }


            	            }
            	            break;

            	    }

            	    otherlv_8=(Token)match(input,45,FOLLOW_12); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_8, grammarAccess.getProcessAccess().getSemicolonKeyword_4_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // InternalReflex.g:466:3: ( (lv_states_9_0= ruleState ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==39||LA7_0==47) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalReflex.g:467:4: (lv_states_9_0= ruleState )
            	    {
            	    // InternalReflex.g:467:4: (lv_states_9_0= ruleState )
            	    // InternalReflex.g:468:5: lv_states_9_0= ruleState
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getProcessAccess().getStatesStateParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_13);
            	    lv_states_9_0=ruleState();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getProcessRule());
            	      					}
            	      					add(
            	      						current,
            	      						"states",
            	      						lv_states_9_0,
            	      						"ru.iaie.reflex.Reflex.State");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_10=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getProcessAccess().getRightCurlyBracketKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProcess"


    // $ANTLR start "entryRuleState"
    // InternalReflex.g:493:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalReflex.g:493:46: (iv_ruleState= ruleState EOF )
            // InternalReflex.g:494:2: iv_ruleState= ruleState EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStateRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleState=ruleState();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleState; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleState"


    // $ANTLR start "ruleState"
    // InternalReflex.g:500:1: ruleState returns [EObject current=null] : ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'state' ( (lv_name_4_0= RULE_ID ) ) ( (lv_looped_5_0= 'looped' ) )? otherlv_6= '{' ( (lv_stateFunction_7_0= ruleStatementSequence ) ) ( (lv_timeoutFunction_8_0= ruleTimeoutFunction ) )? otherlv_9= '}' ) ;
    public final EObject ruleState() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        Token lv_looped_5_0=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        EObject lv_annotations_1_0 = null;

        EObject lv_stateFunction_7_0 = null;

        EObject lv_timeoutFunction_8_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:506:2: ( ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'state' ( (lv_name_4_0= RULE_ID ) ) ( (lv_looped_5_0= 'looped' ) )? otherlv_6= '{' ( (lv_stateFunction_7_0= ruleStatementSequence ) ) ( (lv_timeoutFunction_8_0= ruleTimeoutFunction ) )? otherlv_9= '}' ) )
            // InternalReflex.g:507:2: ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'state' ( (lv_name_4_0= RULE_ID ) ) ( (lv_looped_5_0= 'looped' ) )? otherlv_6= '{' ( (lv_stateFunction_7_0= ruleStatementSequence ) ) ( (lv_timeoutFunction_8_0= ruleTimeoutFunction ) )? otherlv_9= '}' )
            {
            // InternalReflex.g:507:2: ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'state' ( (lv_name_4_0= RULE_ID ) ) ( (lv_looped_5_0= 'looped' ) )? otherlv_6= '{' ( (lv_stateFunction_7_0= ruleStatementSequence ) ) ( (lv_timeoutFunction_8_0= ruleTimeoutFunction ) )? otherlv_9= '}' )
            // InternalReflex.g:508:3: (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'state' ( (lv_name_4_0= RULE_ID ) ) ( (lv_looped_5_0= 'looped' ) )? otherlv_6= '{' ( (lv_stateFunction_7_0= ruleStatementSequence ) ) ( (lv_timeoutFunction_8_0= ruleTimeoutFunction ) )? otherlv_9= '}'
            {
            // InternalReflex.g:508:3: (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==39) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalReflex.g:509:4: otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']'
            	    {
            	    otherlv_0=(Token)match(input,39,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_0, grammarAccess.getStateAccess().getLeftSquareBracketKeyword_0_0());
            	      			
            	    }
            	    // InternalReflex.g:513:4: ( (lv_annotations_1_0= ruleAnnotation ) )
            	    // InternalReflex.g:514:5: (lv_annotations_1_0= ruleAnnotation )
            	    {
            	    // InternalReflex.g:514:5: (lv_annotations_1_0= ruleAnnotation )
            	    // InternalReflex.g:515:6: lv_annotations_1_0= ruleAnnotation
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getStateAccess().getAnnotationsAnnotationParserRuleCall_0_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_annotations_1_0=ruleAnnotation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getStateRule());
            	      						}
            	      						add(
            	      							current,
            	      							"annotations",
            	      							lv_annotations_1_0,
            	      							"ru.iaie.reflex.Reflex.Annotation");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    otherlv_2=(Token)match(input,40,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getStateAccess().getRightSquareBracketKeyword_0_2());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            otherlv_3=(Token)match(input,47,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getStateAccess().getStateKeyword_1());
              		
            }
            // InternalReflex.g:541:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalReflex.g:542:4: (lv_name_4_0= RULE_ID )
            {
            // InternalReflex.g:542:4: (lv_name_4_0= RULE_ID )
            // InternalReflex.g:543:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_4_0, grammarAccess.getStateAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getStateRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_4_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalReflex.g:559:3: ( (lv_looped_5_0= 'looped' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==48) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalReflex.g:560:4: (lv_looped_5_0= 'looped' )
                    {
                    // InternalReflex.g:560:4: (lv_looped_5_0= 'looped' )
                    // InternalReflex.g:561:5: lv_looped_5_0= 'looped'
                    {
                    lv_looped_5_0=(Token)match(input,48,FOLLOW_6); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_looped_5_0, grammarAccess.getStateAccess().getLoopedLoopedKeyword_3_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getStateRule());
                      					}
                      					setWithLastConsumed(current, "looped", true, "looped");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,42,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalReflex.g:577:3: ( (lv_stateFunction_7_0= ruleStatementSequence ) )
            // InternalReflex.g:578:4: (lv_stateFunction_7_0= ruleStatementSequence )
            {
            // InternalReflex.g:578:4: (lv_stateFunction_7_0= ruleStatementSequence )
            // InternalReflex.g:579:5: lv_stateFunction_7_0= ruleStatementSequence
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getStateAccess().getStateFunctionStatementSequenceParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_17);
            lv_stateFunction_7_0=ruleStatementSequence();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getStateRule());
              					}
              					set(
              						current,
              						"stateFunction",
              						lv_stateFunction_7_0,
              						"ru.iaie.reflex.Reflex.StatementSequence");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:596:3: ( (lv_timeoutFunction_8_0= ruleTimeoutFunction ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==55) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalReflex.g:597:4: (lv_timeoutFunction_8_0= ruleTimeoutFunction )
                    {
                    // InternalReflex.g:597:4: (lv_timeoutFunction_8_0= ruleTimeoutFunction )
                    // InternalReflex.g:598:5: lv_timeoutFunction_8_0= ruleTimeoutFunction
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getStateAccess().getTimeoutFunctionTimeoutFunctionParserRuleCall_6_0());
                      				
                    }
                    pushFollow(FOLLOW_18);
                    lv_timeoutFunction_8_0=ruleTimeoutFunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getStateRule());
                      					}
                      					set(
                      						current,
                      						"timeoutFunction",
                      						lv_timeoutFunction_8_0,
                      						"ru.iaie.reflex.Reflex.TimeoutFunction");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getStateAccess().getRightCurlyBracketKeyword_7());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleState"


    // $ANTLR start "entryRuleAnnotation"
    // InternalReflex.g:623:1: entryRuleAnnotation returns [EObject current=null] : iv_ruleAnnotation= ruleAnnotation EOF ;
    public final EObject entryRuleAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotation = null;


        try {
            // InternalReflex.g:623:51: (iv_ruleAnnotation= ruleAnnotation EOF )
            // InternalReflex.g:624:2: iv_ruleAnnotation= ruleAnnotation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAnnotationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAnnotation=ruleAnnotation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAnnotation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnotation"


    // $ANTLR start "ruleAnnotation"
    // InternalReflex.g:630:1: ruleAnnotation returns [EObject current=null] : ( ( ( (lv_key_0_0= ruleAnnotationKey ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) | ( (lv_key_3_0= ruleAnnotationKey ) ) ) ;
    public final EObject ruleAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_value_2_0=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        AntlrDatatypeRuleToken lv_key_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:636:2: ( ( ( ( (lv_key_0_0= ruleAnnotationKey ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) | ( (lv_key_3_0= ruleAnnotationKey ) ) ) )
            // InternalReflex.g:637:2: ( ( ( (lv_key_0_0= ruleAnnotationKey ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) | ( (lv_key_3_0= ruleAnnotationKey ) ) )
            {
            // InternalReflex.g:637:2: ( ( ( (lv_key_0_0= ruleAnnotationKey ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) | ( (lv_key_3_0= ruleAnnotationKey ) ) )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 50:
                    {
                    int LA11_2 = input.LA(3);

                    if ( (LA11_2==RULE_ID) ) {
                        int LA11_5 = input.LA(4);

                        if ( (LA11_5==EOF||LA11_5==40) ) {
                            alt11=2;
                        }
                        else if ( (LA11_5==49) ) {
                            alt11=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 11, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 11, 2, input);

                        throw nvae;
                    }
                    }
                    break;
                case 49:
                    {
                    alt11=1;
                    }
                    break;
                case EOF:
                case 40:
                    {
                    alt11=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 1, input);

                    throw nvae;
                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // InternalReflex.g:638:3: ( ( (lv_key_0_0= ruleAnnotationKey ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
                    {
                    // InternalReflex.g:638:3: ( ( (lv_key_0_0= ruleAnnotationKey ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
                    // InternalReflex.g:639:4: ( (lv_key_0_0= ruleAnnotationKey ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) )
                    {
                    // InternalReflex.g:639:4: ( (lv_key_0_0= ruleAnnotationKey ) )
                    // InternalReflex.g:640:5: (lv_key_0_0= ruleAnnotationKey )
                    {
                    // InternalReflex.g:640:5: (lv_key_0_0= ruleAnnotationKey )
                    // InternalReflex.g:641:6: lv_key_0_0= ruleAnnotationKey
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAnnotationAccess().getKeyAnnotationKeyParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_19);
                    lv_key_0_0=ruleAnnotationKey();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAnnotationRule());
                      						}
                      						set(
                      							current,
                      							"key",
                      							lv_key_0_0,
                      							"ru.iaie.reflex.Reflex.AnnotationKey");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_1=(Token)match(input,49,FOLLOW_20); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getAnnotationAccess().getColonKeyword_0_1());
                      			
                    }
                    // InternalReflex.g:662:4: ( (lv_value_2_0= RULE_STRING ) )
                    // InternalReflex.g:663:5: (lv_value_2_0= RULE_STRING )
                    {
                    // InternalReflex.g:663:5: (lv_value_2_0= RULE_STRING )
                    // InternalReflex.g:664:6: lv_value_2_0= RULE_STRING
                    {
                    lv_value_2_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_2_0, grammarAccess.getAnnotationAccess().getValueSTRINGTerminalRuleCall_0_2_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAnnotationRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_2_0,
                      							"org.eclipse.xtext.common.Terminals.STRING");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:682:3: ( (lv_key_3_0= ruleAnnotationKey ) )
                    {
                    // InternalReflex.g:682:3: ( (lv_key_3_0= ruleAnnotationKey ) )
                    // InternalReflex.g:683:4: (lv_key_3_0= ruleAnnotationKey )
                    {
                    // InternalReflex.g:683:4: (lv_key_3_0= ruleAnnotationKey )
                    // InternalReflex.g:684:5: lv_key_3_0= ruleAnnotationKey
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAnnotationAccess().getKeyAnnotationKeyParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_key_3_0=ruleAnnotationKey();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getAnnotationRule());
                      					}
                      					set(
                      						current,
                      						"key",
                      						lv_key_3_0,
                      						"ru.iaie.reflex.Reflex.AnnotationKey");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnotation"


    // $ANTLR start "entryRuleAnnotationKey"
    // InternalReflex.g:705:1: entryRuleAnnotationKey returns [String current=null] : iv_ruleAnnotationKey= ruleAnnotationKey EOF ;
    public final String entryRuleAnnotationKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAnnotationKey = null;


        try {
            // InternalReflex.g:705:53: (iv_ruleAnnotationKey= ruleAnnotationKey EOF )
            // InternalReflex.g:706:2: iv_ruleAnnotationKey= ruleAnnotationKey EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAnnotationKeyRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAnnotationKey=ruleAnnotationKey();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAnnotationKey.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAnnotationKey"


    // $ANTLR start "ruleAnnotationKey"
    // InternalReflex.g:712:1: ruleAnnotationKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) | this_ID_3= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleAnnotationKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_3=null;


        	enterRule();

        try {
            // InternalReflex.g:718:2: ( ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) | this_ID_3= RULE_ID ) )
            // InternalReflex.g:719:2: ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) | this_ID_3= RULE_ID )
            {
            // InternalReflex.g:719:2: ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) | this_ID_3= RULE_ID )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID) ) {
                int LA12_1 = input.LA(2);

                if ( (LA12_1==50) ) {
                    alt12=1;
                }
                else if ( (LA12_1==EOF||LA12_1==40||LA12_1==49) ) {
                    alt12=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalReflex.g:720:3: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
                    {
                    // InternalReflex.g:720:3: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
                    // InternalReflex.g:721:4: this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_21); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_ID_0);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ID_0, grammarAccess.getAnnotationKeyAccess().getIDTerminalRuleCall_0_0());
                      			
                    }
                    kw=(Token)match(input,50,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getAnnotationKeyAccess().getFullStopKeyword_0_1());
                      			
                    }
                    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_ID_2);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ID_2, grammarAccess.getAnnotationKeyAccess().getIDTerminalRuleCall_0_2());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:742:3: this_ID_3= RULE_ID
                    {
                    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(this_ID_3);
                      		
                    }
                    if ( state.backtracking==0 ) {

                      			newLeafNode(this_ID_3, grammarAccess.getAnnotationKeyAccess().getIDTerminalRuleCall_1());
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAnnotationKey"


    // $ANTLR start "entryRuleImportedVariableList"
    // InternalReflex.g:753:1: entryRuleImportedVariableList returns [EObject current=null] : iv_ruleImportedVariableList= ruleImportedVariableList EOF ;
    public final EObject entryRuleImportedVariableList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedVariableList = null;


        try {
            // InternalReflex.g:753:61: (iv_ruleImportedVariableList= ruleImportedVariableList EOF )
            // InternalReflex.g:754:2: iv_ruleImportedVariableList= ruleImportedVariableList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportedVariableListRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImportedVariableList=ruleImportedVariableList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImportedVariableList; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleImportedVariableList"


    // $ANTLR start "ruleImportedVariableList"
    // InternalReflex.g:760:1: ruleImportedVariableList returns [EObject current=null] : (otherlv_0= 'shared' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) otherlv_4= 'from' otherlv_5= 'process' ( (otherlv_6= RULE_ID ) ) ) ;
    public final EObject ruleImportedVariableList() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalReflex.g:766:2: ( (otherlv_0= 'shared' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) otherlv_4= 'from' otherlv_5= 'process' ( (otherlv_6= RULE_ID ) ) ) )
            // InternalReflex.g:767:2: (otherlv_0= 'shared' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) otherlv_4= 'from' otherlv_5= 'process' ( (otherlv_6= RULE_ID ) ) )
            {
            // InternalReflex.g:767:2: (otherlv_0= 'shared' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) otherlv_4= 'from' otherlv_5= 'process' ( (otherlv_6= RULE_ID ) ) )
            // InternalReflex.g:768:3: otherlv_0= 'shared' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) otherlv_4= 'from' otherlv_5= 'process' ( (otherlv_6= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,51,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImportedVariableListAccess().getSharedKeyword_0());
              		
            }
            // InternalReflex.g:772:3: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )
            // InternalReflex.g:773:4: ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
            {
            // InternalReflex.g:773:4: ( (otherlv_1= RULE_ID ) )
            // InternalReflex.g:774:5: (otherlv_1= RULE_ID )
            {
            // InternalReflex.g:774:5: (otherlv_1= RULE_ID )
            // InternalReflex.g:775:6: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElement(grammarAccess.getImportedVariableListRule());
              						}
              					
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						newLeafNode(otherlv_1, grammarAccess.getImportedVariableListAccess().getVariablesProcessVariableCrossReference_1_0_0());
              					
            }

            }


            }

            // InternalReflex.g:786:4: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==52) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalReflex.g:787:5: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,52,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_2, grammarAccess.getImportedVariableListAccess().getCommaKeyword_1_1_0());
            	      				
            	    }
            	    // InternalReflex.g:791:5: ( (otherlv_3= RULE_ID ) )
            	    // InternalReflex.g:792:6: (otherlv_3= RULE_ID )
            	    {
            	    // InternalReflex.g:792:6: (otherlv_3= RULE_ID )
            	    // InternalReflex.g:793:7: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElement(grammarAccess.getImportedVariableListRule());
            	      							}
            	      						
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_22); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							newLeafNode(otherlv_3, grammarAccess.getImportedVariableListAccess().getVariablesProcessVariableCrossReference_1_1_1_0());
            	      						
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);


            }

            otherlv_4=(Token)match(input,53,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getImportedVariableListAccess().getFromKeyword_2());
              		
            }
            otherlv_5=(Token)match(input,46,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getImportedVariableListAccess().getProcessKeyword_3());
              		
            }
            // InternalReflex.g:814:3: ( (otherlv_6= RULE_ID ) )
            // InternalReflex.g:815:4: (otherlv_6= RULE_ID )
            {
            // InternalReflex.g:815:4: (otherlv_6= RULE_ID )
            // InternalReflex.g:816:5: otherlv_6= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getImportedVariableListRule());
              					}
              				
            }
            otherlv_6=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_6, grammarAccess.getImportedVariableListAccess().getProcessProcessCrossReference_4_0());
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImportedVariableList"


    // $ANTLR start "entryRuleProcessVariable"
    // InternalReflex.g:831:1: entryRuleProcessVariable returns [EObject current=null] : iv_ruleProcessVariable= ruleProcessVariable EOF ;
    public final EObject entryRuleProcessVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessVariable = null;


        try {
            // InternalReflex.g:831:56: (iv_ruleProcessVariable= ruleProcessVariable EOF )
            // InternalReflex.g:832:2: iv_ruleProcessVariable= ruleProcessVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProcessVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProcessVariable=ruleProcessVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProcessVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProcessVariable"


    // $ANTLR start "ruleProcessVariable"
    // InternalReflex.g:838:1: ruleProcessVariable returns [EObject current=null] : ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_shared_2_0= 'shared' ) )? ) ;
    public final EObject ruleProcessVariable() throws RecognitionException {
        EObject current = null;

        Token lv_shared_2_0=null;
        EObject this_PhysicalVariable_0 = null;

        EObject this_ProgramVariable_1 = null;



        	enterRule();

        try {
            // InternalReflex.g:844:2: ( ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_shared_2_0= 'shared' ) )? ) )
            // InternalReflex.g:845:2: ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_shared_2_0= 'shared' ) )? )
            {
            // InternalReflex.g:845:2: ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_shared_2_0= 'shared' ) )? )
            // InternalReflex.g:846:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_shared_2_0= 'shared' ) )?
            {
            // InternalReflex.g:846:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable )
            int alt14=2;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // InternalReflex.g:847:4: this_PhysicalVariable_0= rulePhysicalVariable
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getProcessVariableAccess().getPhysicalVariableParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_24);
                    this_PhysicalVariable_0=rulePhysicalVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_PhysicalVariable_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:856:4: this_ProgramVariable_1= ruleProgramVariable
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getProcessVariableAccess().getProgramVariableParserRuleCall_0_1());
                      			
                    }
                    pushFollow(FOLLOW_24);
                    this_ProgramVariable_1=ruleProgramVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_ProgramVariable_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            // InternalReflex.g:865:3: ( (lv_shared_2_0= 'shared' ) )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==51) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalReflex.g:866:4: (lv_shared_2_0= 'shared' )
                    {
                    // InternalReflex.g:866:4: (lv_shared_2_0= 'shared' )
                    // InternalReflex.g:867:5: lv_shared_2_0= 'shared'
                    {
                    lv_shared_2_0=(Token)match(input,51,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_shared_2_0, grammarAccess.getProcessVariableAccess().getSharedSharedKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getProcessVariableRule());
                      					}
                      					setWithLastConsumed(current, "shared", true, "shared");
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProcessVariable"


    // $ANTLR start "entryRuleGlobalVariable"
    // InternalReflex.g:883:1: entryRuleGlobalVariable returns [EObject current=null] : iv_ruleGlobalVariable= ruleGlobalVariable EOF ;
    public final EObject entryRuleGlobalVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalVariable = null;


        try {
            // InternalReflex.g:883:55: (iv_ruleGlobalVariable= ruleGlobalVariable EOF )
            // InternalReflex.g:884:2: iv_ruleGlobalVariable= ruleGlobalVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getGlobalVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleGlobalVariable=ruleGlobalVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleGlobalVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGlobalVariable"


    // $ANTLR start "ruleGlobalVariable"
    // InternalReflex.g:890:1: ruleGlobalVariable returns [EObject current=null] : ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) otherlv_2= ';' ) ;
    public final EObject ruleGlobalVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_PhysicalVariable_0 = null;

        EObject this_ProgramVariable_1 = null;



        	enterRule();

        try {
            // InternalReflex.g:896:2: ( ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) otherlv_2= ';' ) )
            // InternalReflex.g:897:2: ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) otherlv_2= ';' )
            {
            // InternalReflex.g:897:2: ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) otherlv_2= ';' )
            // InternalReflex.g:898:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) otherlv_2= ';'
            {
            // InternalReflex.g:898:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable )
            int alt16=2;
            alt16 = dfa16.predict(input);
            switch (alt16) {
                case 1 :
                    // InternalReflex.g:899:4: this_PhysicalVariable_0= rulePhysicalVariable
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getGlobalVariableAccess().getPhysicalVariableParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_10);
                    this_PhysicalVariable_0=rulePhysicalVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_PhysicalVariable_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:908:4: this_ProgramVariable_1= ruleProgramVariable
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getGlobalVariableAccess().getProgramVariableParserRuleCall_0_1());
                      			
                    }
                    pushFollow(FOLLOW_10);
                    this_ProgramVariable_1=ruleProgramVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_ProgramVariable_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            otherlv_2=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getGlobalVariableAccess().getSemicolonKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGlobalVariable"


    // $ANTLR start "entryRulePhysicalVariable"
    // InternalReflex.g:925:1: entryRulePhysicalVariable returns [EObject current=null] : iv_rulePhysicalVariable= rulePhysicalVariable EOF ;
    public final EObject entryRulePhysicalVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePhysicalVariable = null;


        try {
            // InternalReflex.g:925:57: (iv_rulePhysicalVariable= rulePhysicalVariable EOF )
            // InternalReflex.g:926:2: iv_rulePhysicalVariable= rulePhysicalVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPhysicalVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePhysicalVariable=rulePhysicalVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePhysicalVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePhysicalVariable"


    // $ANTLR start "rulePhysicalVariable"
    // InternalReflex.g:932:1: rulePhysicalVariable returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_mapping_3_0= rulePortMapping ) ) ) ;
    public final EObject rulePhysicalVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Enumerator lv_type_0_0 = null;

        EObject lv_mapping_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:938:2: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_mapping_3_0= rulePortMapping ) ) ) )
            // InternalReflex.g:939:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_mapping_3_0= rulePortMapping ) ) )
            {
            // InternalReflex.g:939:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_mapping_3_0= rulePortMapping ) ) )
            // InternalReflex.g:940:3: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_mapping_3_0= rulePortMapping ) )
            {
            // InternalReflex.g:940:3: ( (lv_type_0_0= ruleType ) )
            // InternalReflex.g:941:4: (lv_type_0_0= ruleType )
            {
            // InternalReflex.g:941:4: (lv_type_0_0= ruleType )
            // InternalReflex.g:942:5: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPhysicalVariableAccess().getTypeTypeEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_0_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPhysicalVariableRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"ru.iaie.reflex.Reflex.Type");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:959:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:960:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:960:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:961:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getPhysicalVariableAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPhysicalVariableRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,54,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPhysicalVariableAccess().getEqualsSignKeyword_2());
              		
            }
            // InternalReflex.g:981:3: ( (lv_mapping_3_0= rulePortMapping ) )
            // InternalReflex.g:982:4: (lv_mapping_3_0= rulePortMapping )
            {
            // InternalReflex.g:982:4: (lv_mapping_3_0= rulePortMapping )
            // InternalReflex.g:983:5: lv_mapping_3_0= rulePortMapping
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPhysicalVariableAccess().getMappingPortMappingParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_mapping_3_0=rulePortMapping();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPhysicalVariableRule());
              					}
              					set(
              						current,
              						"mapping",
              						lv_mapping_3_0,
              						"ru.iaie.reflex.Reflex.PortMapping");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePhysicalVariable"


    // $ANTLR start "entryRulePortMapping"
    // InternalReflex.g:1004:1: entryRulePortMapping returns [EObject current=null] : iv_rulePortMapping= rulePortMapping EOF ;
    public final EObject entryRulePortMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortMapping = null;


        try {
            // InternalReflex.g:1004:52: (iv_rulePortMapping= rulePortMapping EOF )
            // InternalReflex.g:1005:2: iv_rulePortMapping= rulePortMapping EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPortMappingRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePortMapping=rulePortMapping();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePortMapping; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePortMapping"


    // $ANTLR start "rulePortMapping"
    // InternalReflex.g:1011:1: rulePortMapping returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_bit_2_0= RULE_INTEGER ) )? otherlv_3= ']' ) ;
    public final EObject rulePortMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_bit_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalReflex.g:1017:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_bit_2_0= RULE_INTEGER ) )? otherlv_3= ']' ) )
            // InternalReflex.g:1018:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_bit_2_0= RULE_INTEGER ) )? otherlv_3= ']' )
            {
            // InternalReflex.g:1018:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_bit_2_0= RULE_INTEGER ) )? otherlv_3= ']' )
            // InternalReflex.g:1019:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '[' ( (lv_bit_2_0= RULE_INTEGER ) )? otherlv_3= ']'
            {
            // InternalReflex.g:1019:3: ( (otherlv_0= RULE_ID ) )
            // InternalReflex.g:1020:4: (otherlv_0= RULE_ID )
            {
            // InternalReflex.g:1020:4: (otherlv_0= RULE_ID )
            // InternalReflex.g:1021:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPortMappingRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getPortMappingAccess().getPortPortCrossReference_0_0());
              				
            }

            }


            }

            otherlv_1=(Token)match(input,39,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getPortMappingAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalReflex.g:1036:3: ( (lv_bit_2_0= RULE_INTEGER ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_INTEGER) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalReflex.g:1037:4: (lv_bit_2_0= RULE_INTEGER )
                    {
                    // InternalReflex.g:1037:4: (lv_bit_2_0= RULE_INTEGER )
                    // InternalReflex.g:1038:5: lv_bit_2_0= RULE_INTEGER
                    {
                    lv_bit_2_0=(Token)match(input,RULE_INTEGER,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_bit_2_0, grammarAccess.getPortMappingAccess().getBitINTEGERTerminalRuleCall_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getPortMappingRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"bit",
                      						lv_bit_2_0,
                      						"ru.iaie.reflex.Reflex.INTEGER");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,40,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getPortMappingAccess().getRightSquareBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePortMapping"


    // $ANTLR start "entryRuleProgramVariable"
    // InternalReflex.g:1062:1: entryRuleProgramVariable returns [EObject current=null] : iv_ruleProgramVariable= ruleProgramVariable EOF ;
    public final EObject entryRuleProgramVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgramVariable = null;


        try {
            // InternalReflex.g:1062:56: (iv_ruleProgramVariable= ruleProgramVariable EOF )
            // InternalReflex.g:1063:2: iv_ruleProgramVariable= ruleProgramVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProgramVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProgramVariable=ruleProgramVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProgramVariable; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleProgramVariable"


    // $ANTLR start "ruleProgramVariable"
    // InternalReflex.g:1069:1: ruleProgramVariable returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleProgramVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Enumerator lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1075:2: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalReflex.g:1076:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalReflex.g:1076:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalReflex.g:1077:3: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalReflex.g:1077:3: ( (lv_type_0_0= ruleType ) )
            // InternalReflex.g:1078:4: (lv_type_0_0= ruleType )
            {
            // InternalReflex.g:1078:4: (lv_type_0_0= ruleType )
            // InternalReflex.g:1079:5: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getProgramVariableAccess().getTypeTypeEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_0_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getProgramVariableRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"ru.iaie.reflex.Reflex.Type");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1096:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:1097:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:1097:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:1098:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getProgramVariableAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getProgramVariableRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleProgramVariable"


    // $ANTLR start "entryRuleTimeoutFunction"
    // InternalReflex.g:1118:1: entryRuleTimeoutFunction returns [EObject current=null] : iv_ruleTimeoutFunction= ruleTimeoutFunction EOF ;
    public final EObject entryRuleTimeoutFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeoutFunction = null;


        try {
            // InternalReflex.g:1118:56: (iv_ruleTimeoutFunction= ruleTimeoutFunction EOF )
            // InternalReflex.g:1119:2: iv_ruleTimeoutFunction= ruleTimeoutFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTimeoutFunctionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTimeoutFunction=ruleTimeoutFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTimeoutFunction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimeoutFunction"


    // $ANTLR start "ruleTimeoutFunction"
    // InternalReflex.g:1125:1: ruleTimeoutFunction returns [EObject current=null] : (otherlv_0= 'timeout' (this_TimeAmountOrRef_1= ruleTimeAmountOrRef[$current] | (otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')' ) ) ( (lv_body_5_0= ruleStatement ) ) ) ;
    public final EObject ruleTimeoutFunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_TimeAmountOrRef_1 = null;

        EObject this_TimeAmountOrRef_3 = null;

        EObject lv_body_5_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1131:2: ( (otherlv_0= 'timeout' (this_TimeAmountOrRef_1= ruleTimeAmountOrRef[$current] | (otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')' ) ) ( (lv_body_5_0= ruleStatement ) ) ) )
            // InternalReflex.g:1132:2: (otherlv_0= 'timeout' (this_TimeAmountOrRef_1= ruleTimeAmountOrRef[$current] | (otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')' ) ) ( (lv_body_5_0= ruleStatement ) ) )
            {
            // InternalReflex.g:1132:2: (otherlv_0= 'timeout' (this_TimeAmountOrRef_1= ruleTimeAmountOrRef[$current] | (otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')' ) ) ( (lv_body_5_0= ruleStatement ) ) )
            // InternalReflex.g:1133:3: otherlv_0= 'timeout' (this_TimeAmountOrRef_1= ruleTimeAmountOrRef[$current] | (otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')' ) ) ( (lv_body_5_0= ruleStatement ) )
            {
            otherlv_0=(Token)match(input,55,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTimeoutFunctionAccess().getTimeoutKeyword_0());
              		
            }
            // InternalReflex.g:1137:3: (this_TimeAmountOrRef_1= ruleTimeAmountOrRef[$current] | (otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')' ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=RULE_ID && LA18_0<=RULE_TIME)) ) {
                alt18=1;
            }
            else if ( (LA18_0==56) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // InternalReflex.g:1138:4: this_TimeAmountOrRef_1= ruleTimeAmountOrRef[$current]
                    {
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getTimeoutFunctionRule());
                      				}
                      				newCompositeNode(grammarAccess.getTimeoutFunctionAccess().getTimeAmountOrRefParserRuleCall_1_0());
                      			
                    }
                    pushFollow(FOLLOW_29);
                    this_TimeAmountOrRef_1=ruleTimeAmountOrRef(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_TimeAmountOrRef_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:1150:4: (otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')' )
                    {
                    // InternalReflex.g:1150:4: (otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')' )
                    // InternalReflex.g:1151:5: otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,56,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getTimeoutFunctionAccess().getLeftParenthesisKeyword_1_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getTimeoutFunctionRule());
                      					}
                      					newCompositeNode(grammarAccess.getTimeoutFunctionAccess().getTimeAmountOrRefParserRuleCall_1_1_1());
                      				
                    }
                    pushFollow(FOLLOW_31);
                    this_TimeAmountOrRef_3=ruleTimeAmountOrRef(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current = this_TimeAmountOrRef_3;
                      					afterParserOrEnumRuleCall();
                      				
                    }
                    otherlv_4=(Token)match(input,57,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getTimeoutFunctionAccess().getRightParenthesisKeyword_1_1_2());
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalReflex.g:1172:3: ( (lv_body_5_0= ruleStatement ) )
            // InternalReflex.g:1173:4: (lv_body_5_0= ruleStatement )
            {
            // InternalReflex.g:1173:4: (lv_body_5_0= ruleStatement )
            // InternalReflex.g:1174:5: lv_body_5_0= ruleStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTimeoutFunctionAccess().getBodyStatementParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_body_5_0=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTimeoutFunctionRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_5_0,
              						"ru.iaie.reflex.Reflex.Statement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimeoutFunction"


    // $ANTLR start "ruleTimeAmountOrRef"
    // InternalReflex.g:1196:1: ruleTimeAmountOrRef[EObject in_current] returns [EObject current=in_current] : ( ( (lv_time_0_0= RULE_TIME ) ) | ( (lv_intTime_1_0= RULE_INTEGER ) ) | ( (otherlv_2= RULE_ID ) ) ) ;
    public final EObject ruleTimeAmountOrRef(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token lv_time_0_0=null;
        Token lv_intTime_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalReflex.g:1202:2: ( ( ( (lv_time_0_0= RULE_TIME ) ) | ( (lv_intTime_1_0= RULE_INTEGER ) ) | ( (otherlv_2= RULE_ID ) ) ) )
            // InternalReflex.g:1203:2: ( ( (lv_time_0_0= RULE_TIME ) ) | ( (lv_intTime_1_0= RULE_INTEGER ) ) | ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalReflex.g:1203:2: ( ( (lv_time_0_0= RULE_TIME ) ) | ( (lv_intTime_1_0= RULE_INTEGER ) ) | ( (otherlv_2= RULE_ID ) ) )
            int alt19=3;
            switch ( input.LA(1) ) {
            case RULE_TIME:
                {
                alt19=1;
                }
                break;
            case RULE_INTEGER:
                {
                alt19=2;
                }
                break;
            case RULE_ID:
                {
                alt19=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }

            switch (alt19) {
                case 1 :
                    // InternalReflex.g:1204:3: ( (lv_time_0_0= RULE_TIME ) )
                    {
                    // InternalReflex.g:1204:3: ( (lv_time_0_0= RULE_TIME ) )
                    // InternalReflex.g:1205:4: (lv_time_0_0= RULE_TIME )
                    {
                    // InternalReflex.g:1205:4: (lv_time_0_0= RULE_TIME )
                    // InternalReflex.g:1206:5: lv_time_0_0= RULE_TIME
                    {
                    lv_time_0_0=(Token)match(input,RULE_TIME,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_time_0_0, grammarAccess.getTimeAmountOrRefAccess().getTimeTIMETerminalRuleCall_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getTimeAmountOrRefRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"time",
                      						lv_time_0_0,
                      						"ru.iaie.reflex.Reflex.TIME");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:1223:3: ( (lv_intTime_1_0= RULE_INTEGER ) )
                    {
                    // InternalReflex.g:1223:3: ( (lv_intTime_1_0= RULE_INTEGER ) )
                    // InternalReflex.g:1224:4: (lv_intTime_1_0= RULE_INTEGER )
                    {
                    // InternalReflex.g:1224:4: (lv_intTime_1_0= RULE_INTEGER )
                    // InternalReflex.g:1225:5: lv_intTime_1_0= RULE_INTEGER
                    {
                    lv_intTime_1_0=(Token)match(input,RULE_INTEGER,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_intTime_1_0, grammarAccess.getTimeAmountOrRefAccess().getIntTimeINTEGERTerminalRuleCall_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getTimeAmountOrRefRule());
                      					}
                      					setWithLastConsumed(
                      						current,
                      						"intTime",
                      						lv_intTime_1_0,
                      						"ru.iaie.reflex.Reflex.INTEGER");
                      				
                    }

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:1242:3: ( (otherlv_2= RULE_ID ) )
                    {
                    // InternalReflex.g:1242:3: ( (otherlv_2= RULE_ID ) )
                    // InternalReflex.g:1243:4: (otherlv_2= RULE_ID )
                    {
                    // InternalReflex.g:1243:4: (otherlv_2= RULE_ID )
                    // InternalReflex.g:1244:5: otherlv_2= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getTimeAmountOrRefRule());
                      					}
                      				
                    }
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getTimeAmountOrRefAccess().getRefIdReferenceCrossReference_2_0());
                      				
                    }

                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimeAmountOrRef"


    // $ANTLR start "entryRuleFunction"
    // InternalReflex.g:1259:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // InternalReflex.g:1259:49: (iv_ruleFunction= ruleFunction EOF )
            // InternalReflex.g:1260:2: iv_ruleFunction= ruleFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunction=ruleFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunction"


    // $ANTLR start "ruleFunction"
    // InternalReflex.g:1266:1: ruleFunction returns [EObject current=null] : ( ( (lv_returnType_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleType ) ) )* otherlv_6= ')' otherlv_7= ';' ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Enumerator lv_returnType_0_0 = null;

        Enumerator lv_argTypes_3_0 = null;

        Enumerator lv_argTypes_5_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1272:2: ( ( ( (lv_returnType_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleType ) ) )* otherlv_6= ')' otherlv_7= ';' ) )
            // InternalReflex.g:1273:2: ( ( (lv_returnType_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleType ) ) )* otherlv_6= ')' otherlv_7= ';' )
            {
            // InternalReflex.g:1273:2: ( ( (lv_returnType_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleType ) ) )* otherlv_6= ')' otherlv_7= ';' )
            // InternalReflex.g:1274:3: ( (lv_returnType_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleType ) ) )* otherlv_6= ')' otherlv_7= ';'
            {
            // InternalReflex.g:1274:3: ( (lv_returnType_0_0= ruleType ) )
            // InternalReflex.g:1275:4: (lv_returnType_0_0= ruleType )
            {
            // InternalReflex.g:1275:4: (lv_returnType_0_0= ruleType )
            // InternalReflex.g:1276:5: lv_returnType_0_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFunctionAccess().getReturnTypeTypeEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_returnType_0_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFunctionRule());
              					}
              					set(
              						current,
              						"returnType",
              						lv_returnType_0_0,
              						"ru.iaie.reflex.Reflex.Type");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1293:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:1294:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:1294:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:1295:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getFunctionAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFunctionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,56,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalReflex.g:1315:3: ( (lv_argTypes_3_0= ruleType ) )
            // InternalReflex.g:1316:4: (lv_argTypes_3_0= ruleType )
            {
            // InternalReflex.g:1316:4: (lv_argTypes_3_0= ruleType )
            // InternalReflex.g:1317:5: lv_argTypes_3_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFunctionAccess().getArgTypesTypeEnumRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_34);
            lv_argTypes_3_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getFunctionRule());
              					}
              					add(
              						current,
              						"argTypes",
              						lv_argTypes_3_0,
              						"ru.iaie.reflex.Reflex.Type");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1334:3: (otherlv_4= ',' ( (lv_argTypes_5_0= ruleType ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==52) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalReflex.g:1335:4: otherlv_4= ',' ( (lv_argTypes_5_0= ruleType ) )
            	    {
            	    otherlv_4=(Token)match(input,52,FOLLOW_33); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getFunctionAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalReflex.g:1339:4: ( (lv_argTypes_5_0= ruleType ) )
            	    // InternalReflex.g:1340:5: (lv_argTypes_5_0= ruleType )
            	    {
            	    // InternalReflex.g:1340:5: (lv_argTypes_5_0= ruleType )
            	    // InternalReflex.g:1341:6: lv_argTypes_5_0= ruleType
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getFunctionAccess().getArgTypesTypeEnumRuleCall_4_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_34);
            	    lv_argTypes_5_0=ruleType();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getFunctionRule());
            	      						}
            	      						add(
            	      							current,
            	      							"argTypes",
            	      							lv_argTypes_5_0,
            	      							"ru.iaie.reflex.Reflex.Type");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            otherlv_6=(Token)match(input,57,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_5());
              		
            }
            otherlv_7=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getFunctionAccess().getSemicolonKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunction"


    // $ANTLR start "entryRulePort"
    // InternalReflex.g:1371:1: entryRulePort returns [EObject current=null] : iv_rulePort= rulePort EOF ;
    public final EObject entryRulePort() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePort = null;


        try {
            // InternalReflex.g:1371:45: (iv_rulePort= rulePort EOF )
            // InternalReflex.g:1372:2: iv_rulePort= rulePort EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPortRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePort=rulePort();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePort; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePort"


    // $ANTLR start "rulePort"
    // InternalReflex.g:1378:1: rulePort returns [EObject current=null] : ( ( (lv_type_0_0= rulePortType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= RULE_INTEGER ) ) ( (lv_addr2_3_0= RULE_INTEGER ) ) ( (lv_size_4_0= RULE_INTEGER ) ) otherlv_5= ';' ) ;
    public final EObject rulePort() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_addr1_2_0=null;
        Token lv_addr2_3_0=null;
        Token lv_size_4_0=null;
        Token otherlv_5=null;
        Enumerator lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1384:2: ( ( ( (lv_type_0_0= rulePortType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= RULE_INTEGER ) ) ( (lv_addr2_3_0= RULE_INTEGER ) ) ( (lv_size_4_0= RULE_INTEGER ) ) otherlv_5= ';' ) )
            // InternalReflex.g:1385:2: ( ( (lv_type_0_0= rulePortType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= RULE_INTEGER ) ) ( (lv_addr2_3_0= RULE_INTEGER ) ) ( (lv_size_4_0= RULE_INTEGER ) ) otherlv_5= ';' )
            {
            // InternalReflex.g:1385:2: ( ( (lv_type_0_0= rulePortType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= RULE_INTEGER ) ) ( (lv_addr2_3_0= RULE_INTEGER ) ) ( (lv_size_4_0= RULE_INTEGER ) ) otherlv_5= ';' )
            // InternalReflex.g:1386:3: ( (lv_type_0_0= rulePortType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= RULE_INTEGER ) ) ( (lv_addr2_3_0= RULE_INTEGER ) ) ( (lv_size_4_0= RULE_INTEGER ) ) otherlv_5= ';'
            {
            // InternalReflex.g:1386:3: ( (lv_type_0_0= rulePortType ) )
            // InternalReflex.g:1387:4: (lv_type_0_0= rulePortType )
            {
            // InternalReflex.g:1387:4: (lv_type_0_0= rulePortType )
            // InternalReflex.g:1388:5: lv_type_0_0= rulePortType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPortAccess().getTypePortTypeEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_0_0=rulePortType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPortRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"ru.iaie.reflex.Reflex.PortType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1405:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:1406:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:1406:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:1407:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getPortAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPortRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalReflex.g:1423:3: ( (lv_addr1_2_0= RULE_INTEGER ) )
            // InternalReflex.g:1424:4: (lv_addr1_2_0= RULE_INTEGER )
            {
            // InternalReflex.g:1424:4: (lv_addr1_2_0= RULE_INTEGER )
            // InternalReflex.g:1425:5: lv_addr1_2_0= RULE_INTEGER
            {
            lv_addr1_2_0=(Token)match(input,RULE_INTEGER,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_addr1_2_0, grammarAccess.getPortAccess().getAddr1INTEGERTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPortRule());
              					}
              					setWithLastConsumed(
              						current,
              						"addr1",
              						lv_addr1_2_0,
              						"ru.iaie.reflex.Reflex.INTEGER");
              				
            }

            }


            }

            // InternalReflex.g:1441:3: ( (lv_addr2_3_0= RULE_INTEGER ) )
            // InternalReflex.g:1442:4: (lv_addr2_3_0= RULE_INTEGER )
            {
            // InternalReflex.g:1442:4: (lv_addr2_3_0= RULE_INTEGER )
            // InternalReflex.g:1443:5: lv_addr2_3_0= RULE_INTEGER
            {
            lv_addr2_3_0=(Token)match(input,RULE_INTEGER,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_addr2_3_0, grammarAccess.getPortAccess().getAddr2INTEGERTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPortRule());
              					}
              					setWithLastConsumed(
              						current,
              						"addr2",
              						lv_addr2_3_0,
              						"ru.iaie.reflex.Reflex.INTEGER");
              				
            }

            }


            }

            // InternalReflex.g:1459:3: ( (lv_size_4_0= RULE_INTEGER ) )
            // InternalReflex.g:1460:4: (lv_size_4_0= RULE_INTEGER )
            {
            // InternalReflex.g:1460:4: (lv_size_4_0= RULE_INTEGER )
            // InternalReflex.g:1461:5: lv_size_4_0= RULE_INTEGER
            {
            lv_size_4_0=(Token)match(input,RULE_INTEGER,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_size_4_0, grammarAccess.getPortAccess().getSizeINTEGERTerminalRuleCall_4_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPortRule());
              					}
              					setWithLastConsumed(
              						current,
              						"size",
              						lv_size_4_0,
              						"ru.iaie.reflex.Reflex.INTEGER");
              				
            }

            }


            }

            otherlv_5=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getPortAccess().getSemicolonKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePort"


    // $ANTLR start "entryRuleConst"
    // InternalReflex.g:1485:1: entryRuleConst returns [EObject current=null] : iv_ruleConst= ruleConst EOF ;
    public final EObject entryRuleConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConst = null;


        try {
            // InternalReflex.g:1485:46: (iv_ruleConst= ruleConst EOF )
            // InternalReflex.g:1486:2: iv_ruleConst= ruleConst EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConstRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConst=ruleConst();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConst; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConst"


    // $ANTLR start "ruleConst"
    // InternalReflex.g:1492:1: ruleConst returns [EObject current=null] : (otherlv_0= 'const' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' ) ;
    public final EObject ruleConst() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Enumerator lv_type_1_0 = null;

        EObject lv_value_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1498:2: ( (otherlv_0= 'const' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' ) )
            // InternalReflex.g:1499:2: (otherlv_0= 'const' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' )
            {
            // InternalReflex.g:1499:2: (otherlv_0= 'const' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';' )
            // InternalReflex.g:1500:3: otherlv_0= 'const' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_value_4_0= ruleExpression ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,58,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConstAccess().getConstKeyword_0());
              		
            }
            // InternalReflex.g:1504:3: ( (lv_type_1_0= ruleType ) )
            // InternalReflex.g:1505:4: (lv_type_1_0= ruleType )
            {
            // InternalReflex.g:1505:4: (lv_type_1_0= ruleType )
            // InternalReflex.g:1506:5: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConstAccess().getTypeTypeEnumRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_1_0=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getConstRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_1_0,
              						"ru.iaie.reflex.Reflex.Type");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1523:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalReflex.g:1524:4: (lv_name_2_0= RULE_ID )
            {
            // InternalReflex.g:1524:4: (lv_name_2_0= RULE_ID )
            // InternalReflex.g:1525:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_2_0, grammarAccess.getConstAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getConstRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_2_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_3=(Token)match(input,54,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getConstAccess().getEqualsSignKeyword_3());
              		
            }
            // InternalReflex.g:1545:3: ( (lv_value_4_0= ruleExpression ) )
            // InternalReflex.g:1546:4: (lv_value_4_0= ruleExpression )
            {
            // InternalReflex.g:1546:4: (lv_value_4_0= ruleExpression )
            // InternalReflex.g:1547:5: lv_value_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConstAccess().getValueExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_10);
            lv_value_4_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getConstRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_4_0,
              						"ru.iaie.reflex.Reflex.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getConstAccess().getSemicolonKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConst"


    // $ANTLR start "entryRuleEnum"
    // InternalReflex.g:1572:1: entryRuleEnum returns [EObject current=null] : iv_ruleEnum= ruleEnum EOF ;
    public final EObject entryRuleEnum() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnum = null;


        try {
            // InternalReflex.g:1572:45: (iv_ruleEnum= ruleEnum EOF )
            // InternalReflex.g:1573:2: iv_ruleEnum= ruleEnum EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnum=ruleEnum();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnum; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnum"


    // $ANTLR start "ruleEnum"
    // InternalReflex.g:1579:1: ruleEnum returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_identifier_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}' ) ;
    public final EObject ruleEnum() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_identifier_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_enumMembers_3_0 = null;

        EObject lv_enumMembers_5_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1585:2: ( (otherlv_0= 'enum' ( (lv_identifier_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}' ) )
            // InternalReflex.g:1586:2: (otherlv_0= 'enum' ( (lv_identifier_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}' )
            {
            // InternalReflex.g:1586:2: (otherlv_0= 'enum' ( (lv_identifier_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}' )
            // InternalReflex.g:1587:3: otherlv_0= 'enum' ( (lv_identifier_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,59,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEnumAccess().getEnumKeyword_0());
              		
            }
            // InternalReflex.g:1591:3: ( (lv_identifier_1_0= RULE_ID ) )
            // InternalReflex.g:1592:4: (lv_identifier_1_0= RULE_ID )
            {
            // InternalReflex.g:1592:4: (lv_identifier_1_0= RULE_ID )
            // InternalReflex.g:1593:5: lv_identifier_1_0= RULE_ID
            {
            lv_identifier_1_0=(Token)match(input,RULE_ID,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_identifier_1_0, grammarAccess.getEnumAccess().getIdentifierIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEnumRule());
              					}
              					setWithLastConsumed(
              						current,
              						"identifier",
              						lv_identifier_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,42,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getEnumAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalReflex.g:1613:3: ( (lv_enumMembers_3_0= ruleEnumMember ) )
            // InternalReflex.g:1614:4: (lv_enumMembers_3_0= ruleEnumMember )
            {
            // InternalReflex.g:1614:4: (lv_enumMembers_3_0= ruleEnumMember )
            // InternalReflex.g:1615:5: lv_enumMembers_3_0= ruleEnumMember
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnumAccess().getEnumMembersEnumMemberParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_36);
            lv_enumMembers_3_0=ruleEnumMember();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEnumRule());
              					}
              					add(
              						current,
              						"enumMembers",
              						lv_enumMembers_3_0,
              						"ru.iaie.reflex.Reflex.EnumMember");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1632:3: (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==52) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalReflex.g:1633:4: otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) )
            	    {
            	    otherlv_4=(Token)match(input,52,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getEnumAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalReflex.g:1637:4: ( (lv_enumMembers_5_0= ruleEnumMember ) )
            	    // InternalReflex.g:1638:5: (lv_enumMembers_5_0= ruleEnumMember )
            	    {
            	    // InternalReflex.g:1638:5: (lv_enumMembers_5_0= ruleEnumMember )
            	    // InternalReflex.g:1639:6: lv_enumMembers_5_0= ruleEnumMember
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEnumAccess().getEnumMembersEnumMemberParserRuleCall_4_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_36);
            	    lv_enumMembers_5_0=ruleEnumMember();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEnumRule());
            	      						}
            	      						add(
            	      							current,
            	      							"enumMembers",
            	      							lv_enumMembers_5_0,
            	      							"ru.iaie.reflex.Reflex.EnumMember");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            otherlv_6=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getEnumAccess().getRightCurlyBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnum"


    // $ANTLR start "entryRuleEnumMember"
    // InternalReflex.g:1665:1: entryRuleEnumMember returns [EObject current=null] : iv_ruleEnumMember= ruleEnumMember EOF ;
    public final EObject entryRuleEnumMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumMember = null;


        try {
            // InternalReflex.g:1665:51: (iv_ruleEnumMember= ruleEnumMember EOF )
            // InternalReflex.g:1666:2: iv_ruleEnumMember= ruleEnumMember EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumMemberRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnumMember=ruleEnumMember();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumMember; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumMember"


    // $ANTLR start "ruleEnumMember"
    // InternalReflex.g:1672:1: ruleEnumMember returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )? ) ;
    public final EObject ruleEnumMember() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1678:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )? ) )
            // InternalReflex.g:1679:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )? )
            {
            // InternalReflex.g:1679:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )? )
            // InternalReflex.g:1680:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )?
            {
            // InternalReflex.g:1680:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalReflex.g:1681:4: (lv_name_0_0= RULE_ID )
            {
            // InternalReflex.g:1681:4: (lv_name_0_0= RULE_ID )
            // InternalReflex.g:1682:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getEnumMemberAccess().getNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEnumMemberRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalReflex.g:1698:3: (otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==54) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalReflex.g:1699:4: otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) )
                    {
                    otherlv_1=(Token)match(input,54,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getEnumMemberAccess().getEqualsSignKeyword_1_0());
                      			
                    }
                    // InternalReflex.g:1703:4: ( (lv_value_2_0= ruleExpression ) )
                    // InternalReflex.g:1704:5: (lv_value_2_0= ruleExpression )
                    {
                    // InternalReflex.g:1704:5: (lv_value_2_0= ruleExpression )
                    // InternalReflex.g:1705:6: lv_value_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getEnumMemberAccess().getValueExpressionParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_value_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getEnumMemberRule());
                      						}
                      						set(
                      							current,
                      							"value",
                      							lv_value_2_0,
                      							"ru.iaie.reflex.Reflex.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumMember"


    // $ANTLR start "entryRuleStatement"
    // InternalReflex.g:1727:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalReflex.g:1727:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalReflex.g:1728:2: iv_ruleStatement= ruleStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalReflex.g:1734:1: ruleStatement returns [EObject current=null] : ( ( () otherlv_1= ';' ) | this_CompoundStatement_2= ruleCompoundStatement | this_StartProcStat_3= ruleStartProcStat | this_StopProcStat_4= ruleStopProcStat | this_ErrorStat_5= ruleErrorStat | this_RestartStat_6= ruleRestartStat | this_ResetStat_7= ruleResetStat | this_SetStateStat_8= ruleSetStateStat | this_IfElseStat_9= ruleIfElseStat | this_SwitchStat_10= ruleSwitchStat | (this_Expression_11= ruleExpression otherlv_12= ';' ) ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_12=null;
        EObject this_CompoundStatement_2 = null;

        EObject this_StartProcStat_3 = null;

        EObject this_StopProcStat_4 = null;

        EObject this_ErrorStat_5 = null;

        EObject this_RestartStat_6 = null;

        EObject this_ResetStat_7 = null;

        EObject this_SetStateStat_8 = null;

        EObject this_IfElseStat_9 = null;

        EObject this_SwitchStat_10 = null;

        EObject this_Expression_11 = null;



        	enterRule();

        try {
            // InternalReflex.g:1740:2: ( ( ( () otherlv_1= ';' ) | this_CompoundStatement_2= ruleCompoundStatement | this_StartProcStat_3= ruleStartProcStat | this_StopProcStat_4= ruleStopProcStat | this_ErrorStat_5= ruleErrorStat | this_RestartStat_6= ruleRestartStat | this_ResetStat_7= ruleResetStat | this_SetStateStat_8= ruleSetStateStat | this_IfElseStat_9= ruleIfElseStat | this_SwitchStat_10= ruleSwitchStat | (this_Expression_11= ruleExpression otherlv_12= ';' ) ) )
            // InternalReflex.g:1741:2: ( ( () otherlv_1= ';' ) | this_CompoundStatement_2= ruleCompoundStatement | this_StartProcStat_3= ruleStartProcStat | this_StopProcStat_4= ruleStopProcStat | this_ErrorStat_5= ruleErrorStat | this_RestartStat_6= ruleRestartStat | this_ResetStat_7= ruleResetStat | this_SetStateStat_8= ruleSetStateStat | this_IfElseStat_9= ruleIfElseStat | this_SwitchStat_10= ruleSwitchStat | (this_Expression_11= ruleExpression otherlv_12= ';' ) )
            {
            // InternalReflex.g:1741:2: ( ( () otherlv_1= ';' ) | this_CompoundStatement_2= ruleCompoundStatement | this_StartProcStat_3= ruleStartProcStat | this_StopProcStat_4= ruleStopProcStat | this_ErrorStat_5= ruleErrorStat | this_RestartStat_6= ruleRestartStat | this_ResetStat_7= ruleResetStat | this_SetStateStat_8= ruleSetStateStat | this_IfElseStat_9= ruleIfElseStat | this_SwitchStat_10= ruleSwitchStat | (this_Expression_11= ruleExpression otherlv_12= ';' ) )
            int alt23=11;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt23=1;
                }
                break;
            case 42:
                {
                alt23=2;
                }
                break;
            case 66:
                {
                alt23=3;
                }
                break;
            case 67:
                {
                alt23=4;
                }
                break;
            case 68:
                {
                alt23=5;
                }
                break;
            case 69:
                {
                alt23=6;
                }
                break;
            case 70:
                {
                alt23=7;
                }
                break;
            case 72:
                {
                alt23=8;
                }
                break;
            case 60:
                {
                alt23=9;
                }
                break;
            case 62:
                {
                alt23=10;
                }
                break;
            case RULE_ID:
            case RULE_INTEGER:
            case RULE_TIME:
            case RULE_FLOAT:
            case RULE_BOOL_LITERAL:
            case 46:
            case 56:
            case 79:
            case 80:
            case 90:
            case 91:
            case 92:
            case 93:
                {
                alt23=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalReflex.g:1742:3: ( () otherlv_1= ';' )
                    {
                    // InternalReflex.g:1742:3: ( () otherlv_1= ';' )
                    // InternalReflex.g:1743:4: () otherlv_1= ';'
                    {
                    // InternalReflex.g:1743:4: ()
                    // InternalReflex.g:1744:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getStatementAccess().getStatementAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getStatementAccess().getSemicolonKeyword_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:1756:3: this_CompoundStatement_2= ruleCompoundStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getCompoundStatementParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CompoundStatement_2=ruleCompoundStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CompoundStatement_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalReflex.g:1765:3: this_StartProcStat_3= ruleStartProcStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getStartProcStatParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StartProcStat_3=ruleStartProcStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StartProcStat_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalReflex.g:1774:3: this_StopProcStat_4= ruleStopProcStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getStopProcStatParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StopProcStat_4=ruleStopProcStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StopProcStat_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalReflex.g:1783:3: this_ErrorStat_5= ruleErrorStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getErrorStatParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ErrorStat_5=ruleErrorStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ErrorStat_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalReflex.g:1792:3: this_RestartStat_6= ruleRestartStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getRestartStatParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_RestartStat_6=ruleRestartStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_RestartStat_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalReflex.g:1801:3: this_ResetStat_7= ruleResetStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getResetStatParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ResetStat_7=ruleResetStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ResetStat_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalReflex.g:1810:3: this_SetStateStat_8= ruleSetStateStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getSetStateStatParserRuleCall_7());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SetStateStat_8=ruleSetStateStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SetStateStat_8;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 9 :
                    // InternalReflex.g:1819:3: this_IfElseStat_9= ruleIfElseStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getIfElseStatParserRuleCall_8());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_IfElseStat_9=ruleIfElseStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IfElseStat_9;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 10 :
                    // InternalReflex.g:1828:3: this_SwitchStat_10= ruleSwitchStat
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getSwitchStatParserRuleCall_9());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SwitchStat_10=ruleSwitchStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SwitchStat_10;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 11 :
                    // InternalReflex.g:1837:3: (this_Expression_11= ruleExpression otherlv_12= ';' )
                    {
                    // InternalReflex.g:1837:3: (this_Expression_11= ruleExpression otherlv_12= ';' )
                    // InternalReflex.g:1838:4: this_Expression_11= ruleExpression otherlv_12= ';'
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getStatementAccess().getExpressionParserRuleCall_10_0());
                      			
                    }
                    pushFollow(FOLLOW_10);
                    this_Expression_11=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Expression_11;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_12=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_12, grammarAccess.getStatementAccess().getSemicolonKeyword_10_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleStatementSequence"
    // InternalReflex.g:1855:1: entryRuleStatementSequence returns [EObject current=null] : iv_ruleStatementSequence= ruleStatementSequence EOF ;
    public final EObject entryRuleStatementSequence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementSequence = null;


        try {
            // InternalReflex.g:1855:58: (iv_ruleStatementSequence= ruleStatementSequence EOF )
            // InternalReflex.g:1856:2: iv_ruleStatementSequence= ruleStatementSequence EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementSequenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStatementSequence=ruleStatementSequence();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatementSequence; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStatementSequence"


    // $ANTLR start "ruleStatementSequence"
    // InternalReflex.g:1862:1: ruleStatementSequence returns [EObject current=null] : ( () ( (lv_statements_1_0= ruleStatement ) )* ) ;
    public final EObject ruleStatementSequence() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_1_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1868:2: ( ( () ( (lv_statements_1_0= ruleStatement ) )* ) )
            // InternalReflex.g:1869:2: ( () ( (lv_statements_1_0= ruleStatement ) )* )
            {
            // InternalReflex.g:1869:2: ( () ( (lv_statements_1_0= ruleStatement ) )* )
            // InternalReflex.g:1870:3: () ( (lv_statements_1_0= ruleStatement ) )*
            {
            // InternalReflex.g:1870:3: ()
            // InternalReflex.g:1871:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getStatementSequenceAccess().getStatementSequenceAction_0(),
              					current);
              			
            }

            }

            // InternalReflex.g:1877:3: ( (lv_statements_1_0= ruleStatement ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=RULE_ID && LA24_0<=RULE_TIME)||(LA24_0>=RULE_FLOAT && LA24_0<=RULE_BOOL_LITERAL)||LA24_0==42||(LA24_0>=45 && LA24_0<=46)||LA24_0==56||LA24_0==60||LA24_0==62||(LA24_0>=66 && LA24_0<=70)||LA24_0==72||(LA24_0>=79 && LA24_0<=80)||(LA24_0>=90 && LA24_0<=93)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalReflex.g:1878:4: (lv_statements_1_0= ruleStatement )
            	    {
            	    // InternalReflex.g:1878:4: (lv_statements_1_0= ruleStatement )
            	    // InternalReflex.g:1879:5: lv_statements_1_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getStatementSequenceAccess().getStatementsStatementParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_38);
            	    lv_statements_1_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getStatementSequenceRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_1_0,
            	      						"ru.iaie.reflex.Reflex.Statement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop24;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStatementSequence"


    // $ANTLR start "entryRuleCompoundStatement"
    // InternalReflex.g:1900:1: entryRuleCompoundStatement returns [EObject current=null] : iv_ruleCompoundStatement= ruleCompoundStatement EOF ;
    public final EObject entryRuleCompoundStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompoundStatement = null;


        try {
            // InternalReflex.g:1900:58: (iv_ruleCompoundStatement= ruleCompoundStatement EOF )
            // InternalReflex.g:1901:2: iv_ruleCompoundStatement= ruleCompoundStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCompoundStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCompoundStatement=ruleCompoundStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCompoundStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompoundStatement"


    // $ANTLR start "ruleCompoundStatement"
    // InternalReflex.g:1907:1: ruleCompoundStatement returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) ;
    public final EObject ruleCompoundStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1913:2: ( ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) )
            // InternalReflex.g:1914:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' )
            {
            // InternalReflex.g:1914:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' )
            // InternalReflex.g:1915:3: () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}'
            {
            // InternalReflex.g:1915:3: ()
            // InternalReflex.g:1916:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getCompoundStatementAccess().getCompoundStatementAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,42,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCompoundStatementAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalReflex.g:1926:3: ( (lv_statements_2_0= ruleStatement ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( ((LA25_0>=RULE_ID && LA25_0<=RULE_TIME)||(LA25_0>=RULE_FLOAT && LA25_0<=RULE_BOOL_LITERAL)||LA25_0==42||(LA25_0>=45 && LA25_0<=46)||LA25_0==56||LA25_0==60||LA25_0==62||(LA25_0>=66 && LA25_0<=70)||LA25_0==72||(LA25_0>=79 && LA25_0<=80)||(LA25_0>=90 && LA25_0<=93)) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalReflex.g:1927:4: (lv_statements_2_0= ruleStatement )
            	    {
            	    // InternalReflex.g:1927:4: (lv_statements_2_0= ruleStatement )
            	    // InternalReflex.g:1928:5: lv_statements_2_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getCompoundStatementAccess().getStatementsStatementParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_39);
            	    lv_statements_2_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getCompoundStatementRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_2_0,
            	      						"ru.iaie.reflex.Reflex.Statement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            otherlv_3=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getCompoundStatementAccess().getRightCurlyBracketKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompoundStatement"


    // $ANTLR start "entryRuleIfElseStat"
    // InternalReflex.g:1953:1: entryRuleIfElseStat returns [EObject current=null] : iv_ruleIfElseStat= ruleIfElseStat EOF ;
    public final EObject entryRuleIfElseStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfElseStat = null;


        try {
            // InternalReflex.g:1953:51: (iv_ruleIfElseStat= ruleIfElseStat EOF )
            // InternalReflex.g:1954:2: iv_ruleIfElseStat= ruleIfElseStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfElseStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIfElseStat=ruleIfElseStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfElseStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfElseStat"


    // $ANTLR start "ruleIfElseStat"
    // InternalReflex.g:1960:1: ruleIfElseStat returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )? ) ;
    public final EObject ruleIfElseStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_cond_2_0 = null;

        EObject lv_then_4_0 = null;

        EObject lv_else_6_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1966:2: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )? ) )
            // InternalReflex.g:1967:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )? )
            {
            // InternalReflex.g:1967:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )? )
            // InternalReflex.g:1968:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )?
            {
            otherlv_0=(Token)match(input,60,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIfElseStatAccess().getIfKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,56,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getIfElseStatAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalReflex.g:1976:3: ( (lv_cond_2_0= ruleExpression ) )
            // InternalReflex.g:1977:4: (lv_cond_2_0= ruleExpression )
            {
            // InternalReflex.g:1977:4: (lv_cond_2_0= ruleExpression )
            // InternalReflex.g:1978:5: lv_cond_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfElseStatAccess().getCondExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_31);
            lv_cond_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfElseStatRule());
              					}
              					set(
              						current,
              						"cond",
              						lv_cond_2_0,
              						"ru.iaie.reflex.Reflex.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,57,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getIfElseStatAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalReflex.g:1999:3: ( (lv_then_4_0= ruleStatement ) )
            // InternalReflex.g:2000:4: (lv_then_4_0= ruleStatement )
            {
            // InternalReflex.g:2000:4: (lv_then_4_0= ruleStatement )
            // InternalReflex.g:2001:5: lv_then_4_0= ruleStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfElseStatAccess().getThenStatementParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_40);
            lv_then_4_0=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfElseStatRule());
              					}
              					set(
              						current,
              						"then",
              						lv_then_4_0,
              						"ru.iaie.reflex.Reflex.Statement");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:2018:3: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==61) ) {
                int LA26_1 = input.LA(2);

                if ( (synpred1_InternalReflex()) ) {
                    alt26=1;
                }
            }
            switch (alt26) {
                case 1 :
                    // InternalReflex.g:2019:4: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) )
                    {
                    // InternalReflex.g:2019:4: ( ( 'else' )=>otherlv_5= 'else' )
                    // InternalReflex.g:2020:5: ( 'else' )=>otherlv_5= 'else'
                    {
                    otherlv_5=(Token)match(input,61,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getIfElseStatAccess().getElseKeyword_5_0());
                      				
                    }

                    }

                    // InternalReflex.g:2026:4: ( (lv_else_6_0= ruleStatement ) )
                    // InternalReflex.g:2027:5: (lv_else_6_0= ruleStatement )
                    {
                    // InternalReflex.g:2027:5: (lv_else_6_0= ruleStatement )
                    // InternalReflex.g:2028:6: lv_else_6_0= ruleStatement
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIfElseStatAccess().getElseStatementParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_else_6_0=ruleStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getIfElseStatRule());
                      						}
                      						set(
                      							current,
                      							"else",
                      							lv_else_6_0,
                      							"ru.iaie.reflex.Reflex.Statement");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfElseStat"


    // $ANTLR start "entryRuleSwitchStat"
    // InternalReflex.g:2050:1: entryRuleSwitchStat returns [EObject current=null] : iv_ruleSwitchStat= ruleSwitchStat EOF ;
    public final EObject entryRuleSwitchStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchStat = null;


        try {
            // InternalReflex.g:2050:51: (iv_ruleSwitchStat= ruleSwitchStat EOF )
            // InternalReflex.g:2051:2: iv_ruleSwitchStat= ruleSwitchStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSwitchStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSwitchStat=ruleSwitchStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSwitchStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSwitchStat"


    // $ANTLR start "ruleSwitchStat"
    // InternalReflex.g:2057:1: ruleSwitchStat returns [EObject current=null] : (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* ( (lv_defaultOption_6_0= ruleDefaultStat ) )? otherlv_7= '}' ) ;
    public final EObject ruleSwitchStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        EObject lv_expr_2_0 = null;

        EObject lv_options_5_0 = null;

        EObject lv_defaultOption_6_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2063:2: ( (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* ( (lv_defaultOption_6_0= ruleDefaultStat ) )? otherlv_7= '}' ) )
            // InternalReflex.g:2064:2: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* ( (lv_defaultOption_6_0= ruleDefaultStat ) )? otherlv_7= '}' )
            {
            // InternalReflex.g:2064:2: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* ( (lv_defaultOption_6_0= ruleDefaultStat ) )? otherlv_7= '}' )
            // InternalReflex.g:2065:3: otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* ( (lv_defaultOption_6_0= ruleDefaultStat ) )? otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,62,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSwitchStatAccess().getSwitchKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,56,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSwitchStatAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalReflex.g:2073:3: ( (lv_expr_2_0= ruleExpression ) )
            // InternalReflex.g:2074:4: (lv_expr_2_0= ruleExpression )
            {
            // InternalReflex.g:2074:4: (lv_expr_2_0= ruleExpression )
            // InternalReflex.g:2075:5: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSwitchStatAccess().getExprExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_31);
            lv_expr_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSwitchStatRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_2_0,
              						"ru.iaie.reflex.Reflex.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,57,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getSwitchStatAccess().getRightParenthesisKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,42,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getSwitchStatAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalReflex.g:2100:3: ( (lv_options_5_0= ruleCaseStat ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==63) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalReflex.g:2101:4: (lv_options_5_0= ruleCaseStat )
            	    {
            	    // InternalReflex.g:2101:4: (lv_options_5_0= ruleCaseStat )
            	    // InternalReflex.g:2102:5: lv_options_5_0= ruleCaseStat
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSwitchStatAccess().getOptionsCaseStatParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_41);
            	    lv_options_5_0=ruleCaseStat();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getSwitchStatRule());
            	      					}
            	      					add(
            	      						current,
            	      						"options",
            	      						lv_options_5_0,
            	      						"ru.iaie.reflex.Reflex.CaseStat");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            // InternalReflex.g:2119:3: ( (lv_defaultOption_6_0= ruleDefaultStat ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==64) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalReflex.g:2120:4: (lv_defaultOption_6_0= ruleDefaultStat )
                    {
                    // InternalReflex.g:2120:4: (lv_defaultOption_6_0= ruleDefaultStat )
                    // InternalReflex.g:2121:5: lv_defaultOption_6_0= ruleDefaultStat
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getSwitchStatAccess().getDefaultOptionDefaultStatParserRuleCall_6_0());
                      				
                    }
                    pushFollow(FOLLOW_18);
                    lv_defaultOption_6_0=ruleDefaultStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getSwitchStatRule());
                      					}
                      					set(
                      						current,
                      						"defaultOption",
                      						lv_defaultOption_6_0,
                      						"ru.iaie.reflex.Reflex.DefaultStat");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getSwitchStatAccess().getRightCurlyBracketKeyword_7());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSwitchStat"


    // $ANTLR start "entryRuleCaseStat"
    // InternalReflex.g:2146:1: entryRuleCaseStat returns [EObject current=null] : iv_ruleCaseStat= ruleCaseStat EOF ;
    public final EObject entryRuleCaseStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseStat = null;


        try {
            // InternalReflex.g:2146:49: (iv_ruleCaseStat= ruleCaseStat EOF )
            // InternalReflex.g:2147:2: iv_ruleCaseStat= ruleCaseStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCaseStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCaseStat=ruleCaseStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCaseStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCaseStat"


    // $ANTLR start "ruleCaseStat"
    // InternalReflex.g:2153:1: ruleCaseStat returns [EObject current=null] : (otherlv_0= 'case' ( (lv_option_1_0= ruleExpression ) ) otherlv_2= ':' otherlv_3= '{' this_SwitchOptionStatSequence_4= ruleSwitchOptionStatSequence[$current] otherlv_5= '}' ) ;
    public final EObject ruleCaseStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_option_1_0 = null;

        EObject this_SwitchOptionStatSequence_4 = null;



        	enterRule();

        try {
            // InternalReflex.g:2159:2: ( (otherlv_0= 'case' ( (lv_option_1_0= ruleExpression ) ) otherlv_2= ':' otherlv_3= '{' this_SwitchOptionStatSequence_4= ruleSwitchOptionStatSequence[$current] otherlv_5= '}' ) )
            // InternalReflex.g:2160:2: (otherlv_0= 'case' ( (lv_option_1_0= ruleExpression ) ) otherlv_2= ':' otherlv_3= '{' this_SwitchOptionStatSequence_4= ruleSwitchOptionStatSequence[$current] otherlv_5= '}' )
            {
            // InternalReflex.g:2160:2: (otherlv_0= 'case' ( (lv_option_1_0= ruleExpression ) ) otherlv_2= ':' otherlv_3= '{' this_SwitchOptionStatSequence_4= ruleSwitchOptionStatSequence[$current] otherlv_5= '}' )
            // InternalReflex.g:2161:3: otherlv_0= 'case' ( (lv_option_1_0= ruleExpression ) ) otherlv_2= ':' otherlv_3= '{' this_SwitchOptionStatSequence_4= ruleSwitchOptionStatSequence[$current] otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,63,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getCaseStatAccess().getCaseKeyword_0());
              		
            }
            // InternalReflex.g:2165:3: ( (lv_option_1_0= ruleExpression ) )
            // InternalReflex.g:2166:4: (lv_option_1_0= ruleExpression )
            {
            // InternalReflex.g:2166:4: (lv_option_1_0= ruleExpression )
            // InternalReflex.g:2167:5: lv_option_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCaseStatAccess().getOptionExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_19);
            lv_option_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCaseStatRule());
              					}
              					set(
              						current,
              						"option",
              						lv_option_1_0,
              						"ru.iaie.reflex.Reflex.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,49,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getCaseStatAccess().getColonKeyword_2());
              		
            }
            otherlv_3=(Token)match(input,42,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getCaseStatAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getCaseStatRule());
              			}
              			newCompositeNode(grammarAccess.getCaseStatAccess().getSwitchOptionStatSequenceParserRuleCall_4());
              		
            }
            pushFollow(FOLLOW_18);
            this_SwitchOptionStatSequence_4=ruleSwitchOptionStatSequence(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_SwitchOptionStatSequence_4;
              			afterParserOrEnumRuleCall();
              		
            }
            otherlv_5=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getCaseStatAccess().getRightCurlyBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCaseStat"


    // $ANTLR start "entryRuleDefaultStat"
    // InternalReflex.g:2211:1: entryRuleDefaultStat returns [EObject current=null] : iv_ruleDefaultStat= ruleDefaultStat EOF ;
    public final EObject entryRuleDefaultStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefaultStat = null;


        try {
            // InternalReflex.g:2211:52: (iv_ruleDefaultStat= ruleDefaultStat EOF )
            // InternalReflex.g:2212:2: iv_ruleDefaultStat= ruleDefaultStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDefaultStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDefaultStat=ruleDefaultStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDefaultStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDefaultStat"


    // $ANTLR start "ruleDefaultStat"
    // InternalReflex.g:2218:1: ruleDefaultStat returns [EObject current=null] : (otherlv_0= 'default' otherlv_1= ':' otherlv_2= '{' this_SwitchOptionStatSequence_3= ruleSwitchOptionStatSequence[$current] otherlv_4= '}' ) ;
    public final EObject ruleDefaultStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject this_SwitchOptionStatSequence_3 = null;



        	enterRule();

        try {
            // InternalReflex.g:2224:2: ( (otherlv_0= 'default' otherlv_1= ':' otherlv_2= '{' this_SwitchOptionStatSequence_3= ruleSwitchOptionStatSequence[$current] otherlv_4= '}' ) )
            // InternalReflex.g:2225:2: (otherlv_0= 'default' otherlv_1= ':' otherlv_2= '{' this_SwitchOptionStatSequence_3= ruleSwitchOptionStatSequence[$current] otherlv_4= '}' )
            {
            // InternalReflex.g:2225:2: (otherlv_0= 'default' otherlv_1= ':' otherlv_2= '{' this_SwitchOptionStatSequence_3= ruleSwitchOptionStatSequence[$current] otherlv_4= '}' )
            // InternalReflex.g:2226:3: otherlv_0= 'default' otherlv_1= ':' otherlv_2= '{' this_SwitchOptionStatSequence_3= ruleSwitchOptionStatSequence[$current] otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,64,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getDefaultStatAccess().getDefaultKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,49,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getDefaultStatAccess().getColonKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,42,FOLLOW_42); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getDefaultStatAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              				current = createModelElement(grammarAccess.getDefaultStatRule());
              			}
              			newCompositeNode(grammarAccess.getDefaultStatAccess().getSwitchOptionStatSequenceParserRuleCall_3());
              		
            }
            pushFollow(FOLLOW_18);
            this_SwitchOptionStatSequence_3=ruleSwitchOptionStatSequence(current);

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_SwitchOptionStatSequence_3;
              			afterParserOrEnumRuleCall();
              		
            }
            otherlv_4=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getDefaultStatAccess().getRightCurlyBracketKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDefaultStat"


    // $ANTLR start "ruleSwitchOptionStatSequence"
    // InternalReflex.g:2258:1: ruleSwitchOptionStatSequence[EObject in_current] returns [EObject current=in_current] : ( ( (lv_statements_0_0= ruleStatement ) )* ( (lv_hasBreak_1_0= ruleBreakStat ) )? ) ;
    public final EObject ruleSwitchOptionStatSequence(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        EObject lv_statements_0_0 = null;

        AntlrDatatypeRuleToken lv_hasBreak_1_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2264:2: ( ( ( (lv_statements_0_0= ruleStatement ) )* ( (lv_hasBreak_1_0= ruleBreakStat ) )? ) )
            // InternalReflex.g:2265:2: ( ( (lv_statements_0_0= ruleStatement ) )* ( (lv_hasBreak_1_0= ruleBreakStat ) )? )
            {
            // InternalReflex.g:2265:2: ( ( (lv_statements_0_0= ruleStatement ) )* ( (lv_hasBreak_1_0= ruleBreakStat ) )? )
            // InternalReflex.g:2266:3: ( (lv_statements_0_0= ruleStatement ) )* ( (lv_hasBreak_1_0= ruleBreakStat ) )?
            {
            // InternalReflex.g:2266:3: ( (lv_statements_0_0= ruleStatement ) )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( ((LA29_0>=RULE_ID && LA29_0<=RULE_TIME)||(LA29_0>=RULE_FLOAT && LA29_0<=RULE_BOOL_LITERAL)||LA29_0==42||(LA29_0>=45 && LA29_0<=46)||LA29_0==56||LA29_0==60||LA29_0==62||(LA29_0>=66 && LA29_0<=70)||LA29_0==72||(LA29_0>=79 && LA29_0<=80)||(LA29_0>=90 && LA29_0<=93)) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // InternalReflex.g:2267:4: (lv_statements_0_0= ruleStatement )
            	    {
            	    // InternalReflex.g:2267:4: (lv_statements_0_0= ruleStatement )
            	    // InternalReflex.g:2268:5: lv_statements_0_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSwitchOptionStatSequenceAccess().getStatementsStatementParserRuleCall_0_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_43);
            	    lv_statements_0_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getSwitchOptionStatSequenceRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_0_0,
            	      						"ru.iaie.reflex.Reflex.Statement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            // InternalReflex.g:2285:3: ( (lv_hasBreak_1_0= ruleBreakStat ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==65) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalReflex.g:2286:4: (lv_hasBreak_1_0= ruleBreakStat )
                    {
                    // InternalReflex.g:2286:4: (lv_hasBreak_1_0= ruleBreakStat )
                    // InternalReflex.g:2287:5: lv_hasBreak_1_0= ruleBreakStat
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getSwitchOptionStatSequenceAccess().getHasBreakBreakStatParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_hasBreak_1_0=ruleBreakStat();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getSwitchOptionStatSequenceRule());
                      					}
                      					set(
                      						current,
                      						"hasBreak",
                      						true,
                      						"ru.iaie.reflex.Reflex.BreakStat");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSwitchOptionStatSequence"


    // $ANTLR start "entryRuleBreakStat"
    // InternalReflex.g:2308:1: entryRuleBreakStat returns [String current=null] : iv_ruleBreakStat= ruleBreakStat EOF ;
    public final String entryRuleBreakStat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBreakStat = null;


        try {
            // InternalReflex.g:2308:49: (iv_ruleBreakStat= ruleBreakStat EOF )
            // InternalReflex.g:2309:2: iv_ruleBreakStat= ruleBreakStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBreakStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBreakStat=ruleBreakStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBreakStat.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBreakStat"


    // $ANTLR start "ruleBreakStat"
    // InternalReflex.g:2315:1: ruleBreakStat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'break' kw= ';' ) ;
    public final AntlrDatatypeRuleToken ruleBreakStat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalReflex.g:2321:2: ( (kw= 'break' kw= ';' ) )
            // InternalReflex.g:2322:2: (kw= 'break' kw= ';' )
            {
            // InternalReflex.g:2322:2: (kw= 'break' kw= ';' )
            // InternalReflex.g:2323:3: kw= 'break' kw= ';'
            {
            kw=(Token)match(input,65,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getBreakStatAccess().getBreakKeyword_0());
              		
            }
            kw=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getBreakStatAccess().getSemicolonKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBreakStat"


    // $ANTLR start "entryRuleStartProcStat"
    // InternalReflex.g:2337:1: entryRuleStartProcStat returns [EObject current=null] : iv_ruleStartProcStat= ruleStartProcStat EOF ;
    public final EObject entryRuleStartProcStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStartProcStat = null;


        try {
            // InternalReflex.g:2337:54: (iv_ruleStartProcStat= ruleStartProcStat EOF )
            // InternalReflex.g:2338:2: iv_ruleStartProcStat= ruleStartProcStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStartProcStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStartProcStat=ruleStartProcStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStartProcStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStartProcStat"


    // $ANTLR start "ruleStartProcStat"
    // InternalReflex.g:2344:1: ruleStartProcStat returns [EObject current=null] : (otherlv_0= 'start' otherlv_1= 'process' ( (otherlv_2= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleStartProcStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalReflex.g:2350:2: ( (otherlv_0= 'start' otherlv_1= 'process' ( (otherlv_2= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalReflex.g:2351:2: (otherlv_0= 'start' otherlv_1= 'process' ( (otherlv_2= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalReflex.g:2351:2: (otherlv_0= 'start' otherlv_1= 'process' ( (otherlv_2= RULE_ID ) ) otherlv_3= ';' )
            // InternalReflex.g:2352:3: otherlv_0= 'start' otherlv_1= 'process' ( (otherlv_2= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,66,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getStartProcStatAccess().getStartKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,46,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getStartProcStatAccess().getProcessKeyword_1());
              		
            }
            // InternalReflex.g:2360:3: ( (otherlv_2= RULE_ID ) )
            // InternalReflex.g:2361:4: (otherlv_2= RULE_ID )
            {
            // InternalReflex.g:2361:4: (otherlv_2= RULE_ID )
            // InternalReflex.g:2362:5: otherlv_2= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getStartProcStatRule());
              					}
              				
            }
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_2, grammarAccess.getStartProcStatAccess().getProcessProcessCrossReference_2_0());
              				
            }

            }


            }

            otherlv_3=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getStartProcStatAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStartProcStat"


    // $ANTLR start "entryRuleStopProcStat"
    // InternalReflex.g:2381:1: entryRuleStopProcStat returns [EObject current=null] : iv_ruleStopProcStat= ruleStopProcStat EOF ;
    public final EObject entryRuleStopProcStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStopProcStat = null;


        try {
            // InternalReflex.g:2381:53: (iv_ruleStopProcStat= ruleStopProcStat EOF )
            // InternalReflex.g:2382:2: iv_ruleStopProcStat= ruleStopProcStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStopProcStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStopProcStat=ruleStopProcStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStopProcStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStopProcStat"


    // $ANTLR start "ruleStopProcStat"
    // InternalReflex.g:2388:1: ruleStopProcStat returns [EObject current=null] : ( () otherlv_1= 'stop' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';' ) ;
    public final EObject ruleStopProcStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalReflex.g:2394:2: ( ( () otherlv_1= 'stop' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';' ) )
            // InternalReflex.g:2395:2: ( () otherlv_1= 'stop' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';' )
            {
            // InternalReflex.g:2395:2: ( () otherlv_1= 'stop' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';' )
            // InternalReflex.g:2396:3: () otherlv_1= 'stop' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';'
            {
            // InternalReflex.g:2396:3: ()
            // InternalReflex.g:2397:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getStopProcStatAccess().getStopProcStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,67,FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getStopProcStatAccess().getStopKeyword_1());
              		
            }
            // InternalReflex.g:2407:3: (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==46) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalReflex.g:2408:4: otherlv_2= 'process' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,46,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getStopProcStatAccess().getProcessKeyword_2_0());
                      			
                    }
                    // InternalReflex.g:2412:4: ( (otherlv_3= RULE_ID ) )
                    // InternalReflex.g:2413:5: (otherlv_3= RULE_ID )
                    {
                    // InternalReflex.g:2413:5: (otherlv_3= RULE_ID )
                    // InternalReflex.g:2414:6: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getStopProcStatRule());
                      						}
                      					
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_3, grammarAccess.getStopProcStatAccess().getProcessProcessCrossReference_2_1_0());
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getStopProcStatAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStopProcStat"


    // $ANTLR start "entryRuleErrorStat"
    // InternalReflex.g:2434:1: entryRuleErrorStat returns [EObject current=null] : iv_ruleErrorStat= ruleErrorStat EOF ;
    public final EObject entryRuleErrorStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorStat = null;


        try {
            // InternalReflex.g:2434:50: (iv_ruleErrorStat= ruleErrorStat EOF )
            // InternalReflex.g:2435:2: iv_ruleErrorStat= ruleErrorStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getErrorStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleErrorStat=ruleErrorStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleErrorStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleErrorStat"


    // $ANTLR start "ruleErrorStat"
    // InternalReflex.g:2441:1: ruleErrorStat returns [EObject current=null] : ( () otherlv_1= 'error' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';' ) ;
    public final EObject ruleErrorStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalReflex.g:2447:2: ( ( () otherlv_1= 'error' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';' ) )
            // InternalReflex.g:2448:2: ( () otherlv_1= 'error' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';' )
            {
            // InternalReflex.g:2448:2: ( () otherlv_1= 'error' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';' )
            // InternalReflex.g:2449:3: () otherlv_1= 'error' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';'
            {
            // InternalReflex.g:2449:3: ()
            // InternalReflex.g:2450:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getErrorStatAccess().getErrorStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,68,FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getErrorStatAccess().getErrorKeyword_1());
              		
            }
            // InternalReflex.g:2460:3: (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==46) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalReflex.g:2461:4: otherlv_2= 'process' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,46,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getErrorStatAccess().getProcessKeyword_2_0());
                      			
                    }
                    // InternalReflex.g:2465:4: ( (otherlv_3= RULE_ID ) )
                    // InternalReflex.g:2466:5: (otherlv_3= RULE_ID )
                    {
                    // InternalReflex.g:2466:5: (otherlv_3= RULE_ID )
                    // InternalReflex.g:2467:6: otherlv_3= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getErrorStatRule());
                      						}
                      					
                    }
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_3, grammarAccess.getErrorStatAccess().getProcessProcessCrossReference_2_1_0());
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getErrorStatAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleErrorStat"


    // $ANTLR start "entryRuleRestartStat"
    // InternalReflex.g:2487:1: entryRuleRestartStat returns [EObject current=null] : iv_ruleRestartStat= ruleRestartStat EOF ;
    public final EObject entryRuleRestartStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRestartStat = null;


        try {
            // InternalReflex.g:2487:52: (iv_ruleRestartStat= ruleRestartStat EOF )
            // InternalReflex.g:2488:2: iv_ruleRestartStat= ruleRestartStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRestartStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRestartStat=ruleRestartStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRestartStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRestartStat"


    // $ANTLR start "ruleRestartStat"
    // InternalReflex.g:2494:1: ruleRestartStat returns [EObject current=null] : ( () otherlv_1= 'restart' otherlv_2= ';' ) ;
    public final EObject ruleRestartStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalReflex.g:2500:2: ( ( () otherlv_1= 'restart' otherlv_2= ';' ) )
            // InternalReflex.g:2501:2: ( () otherlv_1= 'restart' otherlv_2= ';' )
            {
            // InternalReflex.g:2501:2: ( () otherlv_1= 'restart' otherlv_2= ';' )
            // InternalReflex.g:2502:3: () otherlv_1= 'restart' otherlv_2= ';'
            {
            // InternalReflex.g:2502:3: ()
            // InternalReflex.g:2503:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRestartStatAccess().getRestartStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,69,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRestartStatAccess().getRestartKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getRestartStatAccess().getSemicolonKeyword_2());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRestartStat"


    // $ANTLR start "entryRuleResetStat"
    // InternalReflex.g:2521:1: entryRuleResetStat returns [EObject current=null] : iv_ruleResetStat= ruleResetStat EOF ;
    public final EObject entryRuleResetStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResetStat = null;


        try {
            // InternalReflex.g:2521:50: (iv_ruleResetStat= ruleResetStat EOF )
            // InternalReflex.g:2522:2: iv_ruleResetStat= ruleResetStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getResetStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleResetStat=ruleResetStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleResetStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleResetStat"


    // $ANTLR start "ruleResetStat"
    // InternalReflex.g:2528:1: ruleResetStat returns [EObject current=null] : ( () otherlv_1= 'reset' otherlv_2= 'timer' otherlv_3= ';' ) ;
    public final EObject ruleResetStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalReflex.g:2534:2: ( ( () otherlv_1= 'reset' otherlv_2= 'timer' otherlv_3= ';' ) )
            // InternalReflex.g:2535:2: ( () otherlv_1= 'reset' otherlv_2= 'timer' otherlv_3= ';' )
            {
            // InternalReflex.g:2535:2: ( () otherlv_1= 'reset' otherlv_2= 'timer' otherlv_3= ';' )
            // InternalReflex.g:2536:3: () otherlv_1= 'reset' otherlv_2= 'timer' otherlv_3= ';'
            {
            // InternalReflex.g:2536:3: ()
            // InternalReflex.g:2537:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getResetStatAccess().getResetStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,70,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getResetStatAccess().getResetKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,71,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getResetStatAccess().getTimerKeyword_2());
              		
            }
            otherlv_3=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getResetStatAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleResetStat"


    // $ANTLR start "entryRuleSetStateStat"
    // InternalReflex.g:2559:1: entryRuleSetStateStat returns [EObject current=null] : iv_ruleSetStateStat= ruleSetStateStat EOF ;
    public final EObject entryRuleSetStateStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetStateStat = null;


        try {
            // InternalReflex.g:2559:53: (iv_ruleSetStateStat= ruleSetStateStat EOF )
            // InternalReflex.g:2560:2: iv_ruleSetStateStat= ruleSetStateStat EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSetStateStatRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSetStateStat=ruleSetStateStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSetStateStat; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSetStateStat"


    // $ANTLR start "ruleSetStateStat"
    // InternalReflex.g:2566:1: ruleSetStateStat returns [EObject current=null] : ( () otherlv_1= 'set' ( ( ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state' ) | (otherlv_4= 'state' ( (otherlv_5= RULE_ID ) ) ) ) otherlv_6= ';' ) ;
    public final EObject ruleSetStateStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_next_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalReflex.g:2572:2: ( ( () otherlv_1= 'set' ( ( ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state' ) | (otherlv_4= 'state' ( (otherlv_5= RULE_ID ) ) ) ) otherlv_6= ';' ) )
            // InternalReflex.g:2573:2: ( () otherlv_1= 'set' ( ( ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state' ) | (otherlv_4= 'state' ( (otherlv_5= RULE_ID ) ) ) ) otherlv_6= ';' )
            {
            // InternalReflex.g:2573:2: ( () otherlv_1= 'set' ( ( ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state' ) | (otherlv_4= 'state' ( (otherlv_5= RULE_ID ) ) ) ) otherlv_6= ';' )
            // InternalReflex.g:2574:3: () otherlv_1= 'set' ( ( ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state' ) | (otherlv_4= 'state' ( (otherlv_5= RULE_ID ) ) ) ) otherlv_6= ';'
            {
            // InternalReflex.g:2574:3: ()
            // InternalReflex.g:2575:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSetStateStatAccess().getSetStateStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,72,FOLLOW_46); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSetStateStatAccess().getSetKeyword_1());
              		
            }
            // InternalReflex.g:2585:3: ( ( ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state' ) | (otherlv_4= 'state' ( (otherlv_5= RULE_ID ) ) ) )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==73) ) {
                alt33=1;
            }
            else if ( (LA33_0==47) ) {
                alt33=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // InternalReflex.g:2586:4: ( ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state' )
                    {
                    // InternalReflex.g:2586:4: ( ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state' )
                    // InternalReflex.g:2587:5: ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state'
                    {
                    // InternalReflex.g:2587:5: ( (lv_next_2_0= 'next' ) )
                    // InternalReflex.g:2588:6: (lv_next_2_0= 'next' )
                    {
                    // InternalReflex.g:2588:6: (lv_next_2_0= 'next' )
                    // InternalReflex.g:2589:7: lv_next_2_0= 'next'
                    {
                    lv_next_2_0=(Token)match(input,73,FOLLOW_47); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(lv_next_2_0, grammarAccess.getSetStateStatAccess().getNextNextKeyword_2_0_0_0());
                      						
                    }
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getSetStateStatRule());
                      							}
                      							setWithLastConsumed(current, "next", true, "next");
                      						
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,47,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_3, grammarAccess.getSetStateStatAccess().getStateKeyword_2_0_1());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:2607:4: (otherlv_4= 'state' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // InternalReflex.g:2607:4: (otherlv_4= 'state' ( (otherlv_5= RULE_ID ) ) )
                    // InternalReflex.g:2608:5: otherlv_4= 'state' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,47,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getSetStateStatAccess().getStateKeyword_2_1_0());
                      				
                    }
                    // InternalReflex.g:2612:5: ( (otherlv_5= RULE_ID ) )
                    // InternalReflex.g:2613:6: (otherlv_5= RULE_ID )
                    {
                    // InternalReflex.g:2613:6: (otherlv_5= RULE_ID )
                    // InternalReflex.g:2614:7: otherlv_5= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      							if (current==null) {
                      								current = createModelElement(grammarAccess.getSetStateStatRule());
                      							}
                      						
                    }
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      							newLeafNode(otherlv_5, grammarAccess.getSetStateStatAccess().getStateStateCrossReference_2_1_1_0());
                      						
                    }

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getSetStateStatAccess().getSemicolonKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSetStateStat"


    // $ANTLR start "entryRuleInfixOp"
    // InternalReflex.g:2635:1: entryRuleInfixOp returns [EObject current=null] : iv_ruleInfixOp= ruleInfixOp EOF ;
    public final EObject entryRuleInfixOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfixOp = null;


        try {
            // InternalReflex.g:2635:48: (iv_ruleInfixOp= ruleInfixOp EOF )
            // InternalReflex.g:2636:2: iv_ruleInfixOp= ruleInfixOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getInfixOpRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleInfixOp=ruleInfixOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleInfixOp; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInfixOp"


    // $ANTLR start "ruleInfixOp"
    // InternalReflex.g:2642:1: ruleInfixOp returns [EObject current=null] : ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleInfixOp() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Enumerator lv_op_0_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2648:2: ( ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (otherlv_1= RULE_ID ) ) ) )
            // InternalReflex.g:2649:2: ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalReflex.g:2649:2: ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (otherlv_1= RULE_ID ) ) )
            // InternalReflex.g:2650:3: ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (otherlv_1= RULE_ID ) )
            {
            // InternalReflex.g:2650:3: ( (lv_op_0_0= ruleInfixPostfixOp ) )
            // InternalReflex.g:2651:4: (lv_op_0_0= ruleInfixPostfixOp )
            {
            // InternalReflex.g:2651:4: (lv_op_0_0= ruleInfixPostfixOp )
            // InternalReflex.g:2652:5: lv_op_0_0= ruleInfixPostfixOp
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getInfixOpAccess().getOpInfixPostfixOpEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_op_0_0=ruleInfixPostfixOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getInfixOpRule());
              					}
              					set(
              						current,
              						"op",
              						lv_op_0_0,
              						"ru.iaie.reflex.Reflex.InfixPostfixOp");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:2669:3: ( (otherlv_1= RULE_ID ) )
            // InternalReflex.g:2670:4: (otherlv_1= RULE_ID )
            {
            // InternalReflex.g:2670:4: (otherlv_1= RULE_ID )
            // InternalReflex.g:2671:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getInfixOpRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getInfixOpAccess().getRefIdReferenceCrossReference_1_0());
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInfixOp"


    // $ANTLR start "entryRulePostfixOp"
    // InternalReflex.g:2686:1: entryRulePostfixOp returns [EObject current=null] : iv_rulePostfixOp= rulePostfixOp EOF ;
    public final EObject entryRulePostfixOp() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixOp = null;


        try {
            // InternalReflex.g:2686:50: (iv_rulePostfixOp= rulePostfixOp EOF )
            // InternalReflex.g:2687:2: iv_rulePostfixOp= rulePostfixOp EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPostfixOpRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePostfixOp=rulePostfixOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePostfixOp; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePostfixOp"


    // $ANTLR start "rulePostfixOp"
    // InternalReflex.g:2693:1: rulePostfixOp returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) ) ;
    public final EObject rulePostfixOp() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Enumerator lv_op_1_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2699:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) ) )
            // InternalReflex.g:2700:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) )
            {
            // InternalReflex.g:2700:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) )
            // InternalReflex.g:2701:3: ( (otherlv_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) )
            {
            // InternalReflex.g:2701:3: ( (otherlv_0= RULE_ID ) )
            // InternalReflex.g:2702:4: (otherlv_0= RULE_ID )
            {
            // InternalReflex.g:2702:4: (otherlv_0= RULE_ID )
            // InternalReflex.g:2703:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPostfixOpRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_48); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getPostfixOpAccess().getRefIdReferenceCrossReference_0_0());
              				
            }

            }


            }

            // InternalReflex.g:2714:3: ( (lv_op_1_0= ruleInfixPostfixOp ) )
            // InternalReflex.g:2715:4: (lv_op_1_0= ruleInfixPostfixOp )
            {
            // InternalReflex.g:2715:4: (lv_op_1_0= ruleInfixPostfixOp )
            // InternalReflex.g:2716:5: lv_op_1_0= ruleInfixPostfixOp
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPostfixOpAccess().getOpInfixPostfixOpEnumRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_op_1_0=ruleInfixPostfixOp();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPostfixOpRule());
              					}
              					set(
              						current,
              						"op",
              						lv_op_1_0,
              						"ru.iaie.reflex.Reflex.InfixPostfixOp");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePostfixOp"


    // $ANTLR start "entryRuleFunctionCall"
    // InternalReflex.g:2737:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // InternalReflex.g:2737:53: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // InternalReflex.g:2738:2: iv_ruleFunctionCall= ruleFunctionCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFunctionCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFunctionCall=ruleFunctionCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFunctionCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFunctionCall"


    // $ANTLR start "ruleFunctionCall"
    // InternalReflex.g:2744:1: ruleFunctionCall returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleFunctionCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_args_2_0 = null;

        EObject lv_args_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2750:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')' ) )
            // InternalReflex.g:2751:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')' )
            {
            // InternalReflex.g:2751:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')' )
            // InternalReflex.g:2752:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')'
            {
            // InternalReflex.g:2752:3: ( (otherlv_0= RULE_ID ) )
            // InternalReflex.g:2753:4: (otherlv_0= RULE_ID )
            {
            // InternalReflex.g:2753:4: (otherlv_0= RULE_ID )
            // InternalReflex.g:2754:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFunctionCallRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getFunctionCallAccess().getFunctionFunctionCrossReference_0_0());
              				
            }

            }


            }

            otherlv_1=(Token)match(input,56,FOLLOW_49); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalReflex.g:2769:3: ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=RULE_ID && LA35_0<=RULE_TIME)||(LA35_0>=RULE_FLOAT && LA35_0<=RULE_BOOL_LITERAL)||LA35_0==46||LA35_0==56||(LA35_0>=79 && LA35_0<=80)||(LA35_0>=90 && LA35_0<=93)) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalReflex.g:2770:4: ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )*
                    {
                    // InternalReflex.g:2770:4: ( (lv_args_2_0= ruleExpression ) )
                    // InternalReflex.g:2771:5: (lv_args_2_0= ruleExpression )
                    {
                    // InternalReflex.g:2771:5: (lv_args_2_0= ruleExpression )
                    // InternalReflex.g:2772:6: lv_args_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_34);
                    lv_args_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getFunctionCallRule());
                      						}
                      						add(
                      							current,
                      							"args",
                      							lv_args_2_0,
                      							"ru.iaie.reflex.Reflex.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalReflex.g:2789:4: (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==52) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // InternalReflex.g:2790:5: otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,52,FOLLOW_29); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getFunctionCallAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalReflex.g:2794:5: ( (lv_args_4_0= ruleExpression ) )
                    	    // InternalReflex.g:2795:6: (lv_args_4_0= ruleExpression )
                    	    {
                    	    // InternalReflex.g:2795:6: (lv_args_4_0= ruleExpression )
                    	    // InternalReflex.g:2796:7: lv_args_4_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_34);
                    	    lv_args_4_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getFunctionCallRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"args",
                    	      								lv_args_4_0,
                    	      								"ru.iaie.reflex.Reflex.Expression");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getFunctionCallAccess().getRightParenthesisKeyword_3());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFunctionCall"


    // $ANTLR start "entryRuleCheckStateExpression"
    // InternalReflex.g:2823:1: entryRuleCheckStateExpression returns [EObject current=null] : iv_ruleCheckStateExpression= ruleCheckStateExpression EOF ;
    public final EObject entryRuleCheckStateExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCheckStateExpression = null;


        try {
            // InternalReflex.g:2823:61: (iv_ruleCheckStateExpression= ruleCheckStateExpression EOF )
            // InternalReflex.g:2824:2: iv_ruleCheckStateExpression= ruleCheckStateExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCheckStateExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCheckStateExpression=ruleCheckStateExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCheckStateExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCheckStateExpression"


    // $ANTLR start "ruleCheckStateExpression"
    // InternalReflex.g:2830:1: ruleCheckStateExpression returns [EObject current=null] : (otherlv_0= 'process' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'in' otherlv_3= 'state' ( (lv_qualfier_4_0= ruleStateQualifier ) ) ) ;
    public final EObject ruleCheckStateExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Enumerator lv_qualfier_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2836:2: ( (otherlv_0= 'process' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'in' otherlv_3= 'state' ( (lv_qualfier_4_0= ruleStateQualifier ) ) ) )
            // InternalReflex.g:2837:2: (otherlv_0= 'process' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'in' otherlv_3= 'state' ( (lv_qualfier_4_0= ruleStateQualifier ) ) )
            {
            // InternalReflex.g:2837:2: (otherlv_0= 'process' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'in' otherlv_3= 'state' ( (lv_qualfier_4_0= ruleStateQualifier ) ) )
            // InternalReflex.g:2838:3: otherlv_0= 'process' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'in' otherlv_3= 'state' ( (lv_qualfier_4_0= ruleStateQualifier ) )
            {
            otherlv_0=(Token)match(input,46,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getCheckStateExpressionAccess().getProcessKeyword_0());
              		
            }
            // InternalReflex.g:2842:3: ( (otherlv_1= RULE_ID ) )
            // InternalReflex.g:2843:4: (otherlv_1= RULE_ID )
            {
            // InternalReflex.g:2843:4: (otherlv_1= RULE_ID )
            // InternalReflex.g:2844:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getCheckStateExpressionRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_50); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getCheckStateExpressionAccess().getProcessProcessCrossReference_1_0());
              				
            }

            }


            }

            otherlv_2=(Token)match(input,74,FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getCheckStateExpressionAccess().getInKeyword_2());
              		
            }
            otherlv_3=(Token)match(input,47,FOLLOW_51); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getCheckStateExpressionAccess().getStateKeyword_3());
              		
            }
            // InternalReflex.g:2863:3: ( (lv_qualfier_4_0= ruleStateQualifier ) )
            // InternalReflex.g:2864:4: (lv_qualfier_4_0= ruleStateQualifier )
            {
            // InternalReflex.g:2864:4: (lv_qualfier_4_0= ruleStateQualifier )
            // InternalReflex.g:2865:5: lv_qualfier_4_0= ruleStateQualifier
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCheckStateExpressionAccess().getQualfierStateQualifierEnumRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_qualfier_4_0=ruleStateQualifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCheckStateExpressionRule());
              					}
              					set(
              						current,
              						"qualfier",
              						lv_qualfier_4_0,
              						"ru.iaie.reflex.Reflex.StateQualifier");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCheckStateExpression"


    // $ANTLR start "entryRulePrimaryExpression"
    // InternalReflex.g:2886:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalReflex.g:2886:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalReflex.g:2887:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrimaryExpression=rulePrimaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimaryExpression"


    // $ANTLR start "rulePrimaryExpression"
    // InternalReflex.g:2893:1: rulePrimaryExpression returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) | ( () ( (lv_integer_2_0= RULE_INTEGER ) ) ) | ( () ( (lv_floating_4_0= RULE_FLOAT ) ) ) | ( () ( (lv_bool_6_0= RULE_BOOL_LITERAL ) ) ) | ( () ( (lv_time_8_0= RULE_TIME ) ) ) | (otherlv_9= '(' ( (lv_nestedExpr_10_0= ruleExpression ) ) otherlv_11= ')' ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_integer_2_0=null;
        Token lv_floating_4_0=null;
        Token lv_bool_6_0=null;
        Token lv_time_8_0=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        EObject lv_nestedExpr_10_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2899:2: ( ( ( (otherlv_0= RULE_ID ) ) | ( () ( (lv_integer_2_0= RULE_INTEGER ) ) ) | ( () ( (lv_floating_4_0= RULE_FLOAT ) ) ) | ( () ( (lv_bool_6_0= RULE_BOOL_LITERAL ) ) ) | ( () ( (lv_time_8_0= RULE_TIME ) ) ) | (otherlv_9= '(' ( (lv_nestedExpr_10_0= ruleExpression ) ) otherlv_11= ')' ) ) )
            // InternalReflex.g:2900:2: ( ( (otherlv_0= RULE_ID ) ) | ( () ( (lv_integer_2_0= RULE_INTEGER ) ) ) | ( () ( (lv_floating_4_0= RULE_FLOAT ) ) ) | ( () ( (lv_bool_6_0= RULE_BOOL_LITERAL ) ) ) | ( () ( (lv_time_8_0= RULE_TIME ) ) ) | (otherlv_9= '(' ( (lv_nestedExpr_10_0= ruleExpression ) ) otherlv_11= ')' ) )
            {
            // InternalReflex.g:2900:2: ( ( (otherlv_0= RULE_ID ) ) | ( () ( (lv_integer_2_0= RULE_INTEGER ) ) ) | ( () ( (lv_floating_4_0= RULE_FLOAT ) ) ) | ( () ( (lv_bool_6_0= RULE_BOOL_LITERAL ) ) ) | ( () ( (lv_time_8_0= RULE_TIME ) ) ) | (otherlv_9= '(' ( (lv_nestedExpr_10_0= ruleExpression ) ) otherlv_11= ')' ) )
            int alt36=6;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt36=1;
                }
                break;
            case RULE_INTEGER:
                {
                alt36=2;
                }
                break;
            case RULE_FLOAT:
                {
                alt36=3;
                }
                break;
            case RULE_BOOL_LITERAL:
                {
                alt36=4;
                }
                break;
            case RULE_TIME:
                {
                alt36=5;
                }
                break;
            case 56:
                {
                alt36=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }

            switch (alt36) {
                case 1 :
                    // InternalReflex.g:2901:3: ( (otherlv_0= RULE_ID ) )
                    {
                    // InternalReflex.g:2901:3: ( (otherlv_0= RULE_ID ) )
                    // InternalReflex.g:2902:4: (otherlv_0= RULE_ID )
                    {
                    // InternalReflex.g:2902:4: (otherlv_0= RULE_ID )
                    // InternalReflex.g:2903:5: otherlv_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                      					}
                      				
                    }
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_0, grammarAccess.getPrimaryExpressionAccess().getReferenceIdReferenceCrossReference_0_0());
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:2915:3: ( () ( (lv_integer_2_0= RULE_INTEGER ) ) )
                    {
                    // InternalReflex.g:2915:3: ( () ( (lv_integer_2_0= RULE_INTEGER ) ) )
                    // InternalReflex.g:2916:4: () ( (lv_integer_2_0= RULE_INTEGER ) )
                    {
                    // InternalReflex.g:2916:4: ()
                    // InternalReflex.g:2917:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalReflex.g:2923:4: ( (lv_integer_2_0= RULE_INTEGER ) )
                    // InternalReflex.g:2924:5: (lv_integer_2_0= RULE_INTEGER )
                    {
                    // InternalReflex.g:2924:5: (lv_integer_2_0= RULE_INTEGER )
                    // InternalReflex.g:2925:6: lv_integer_2_0= RULE_INTEGER
                    {
                    lv_integer_2_0=(Token)match(input,RULE_INTEGER,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_integer_2_0, grammarAccess.getPrimaryExpressionAccess().getIntegerINTEGERTerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"integer",
                      							lv_integer_2_0,
                      							"ru.iaie.reflex.Reflex.INTEGER");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:2943:3: ( () ( (lv_floating_4_0= RULE_FLOAT ) ) )
                    {
                    // InternalReflex.g:2943:3: ( () ( (lv_floating_4_0= RULE_FLOAT ) ) )
                    // InternalReflex.g:2944:4: () ( (lv_floating_4_0= RULE_FLOAT ) )
                    {
                    // InternalReflex.g:2944:4: ()
                    // InternalReflex.g:2945:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalReflex.g:2951:4: ( (lv_floating_4_0= RULE_FLOAT ) )
                    // InternalReflex.g:2952:5: (lv_floating_4_0= RULE_FLOAT )
                    {
                    // InternalReflex.g:2952:5: (lv_floating_4_0= RULE_FLOAT )
                    // InternalReflex.g:2953:6: lv_floating_4_0= RULE_FLOAT
                    {
                    lv_floating_4_0=(Token)match(input,RULE_FLOAT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_floating_4_0, grammarAccess.getPrimaryExpressionAccess().getFloatingFLOATTerminalRuleCall_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"floating",
                      							lv_floating_4_0,
                      							"ru.iaie.reflex.Reflex.FLOAT");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:2971:3: ( () ( (lv_bool_6_0= RULE_BOOL_LITERAL ) ) )
                    {
                    // InternalReflex.g:2971:3: ( () ( (lv_bool_6_0= RULE_BOOL_LITERAL ) ) )
                    // InternalReflex.g:2972:4: () ( (lv_bool_6_0= RULE_BOOL_LITERAL ) )
                    {
                    // InternalReflex.g:2972:4: ()
                    // InternalReflex.g:2973:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalReflex.g:2979:4: ( (lv_bool_6_0= RULE_BOOL_LITERAL ) )
                    // InternalReflex.g:2980:5: (lv_bool_6_0= RULE_BOOL_LITERAL )
                    {
                    // InternalReflex.g:2980:5: (lv_bool_6_0= RULE_BOOL_LITERAL )
                    // InternalReflex.g:2981:6: lv_bool_6_0= RULE_BOOL_LITERAL
                    {
                    lv_bool_6_0=(Token)match(input,RULE_BOOL_LITERAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_bool_6_0, grammarAccess.getPrimaryExpressionAccess().getBoolBOOL_LITERALTerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"bool",
                      							lv_bool_6_0,
                      							"ru.iaie.reflex.Reflex.BOOL_LITERAL");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalReflex.g:2999:3: ( () ( (lv_time_8_0= RULE_TIME ) ) )
                    {
                    // InternalReflex.g:2999:3: ( () ( (lv_time_8_0= RULE_TIME ) ) )
                    // InternalReflex.g:3000:4: () ( (lv_time_8_0= RULE_TIME ) )
                    {
                    // InternalReflex.g:3000:4: ()
                    // InternalReflex.g:3001:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_4_0(),
                      						current);
                      				
                    }

                    }

                    // InternalReflex.g:3007:4: ( (lv_time_8_0= RULE_TIME ) )
                    // InternalReflex.g:3008:5: (lv_time_8_0= RULE_TIME )
                    {
                    // InternalReflex.g:3008:5: (lv_time_8_0= RULE_TIME )
                    // InternalReflex.g:3009:6: lv_time_8_0= RULE_TIME
                    {
                    lv_time_8_0=(Token)match(input,RULE_TIME,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_time_8_0, grammarAccess.getPrimaryExpressionAccess().getTimeTIMETerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getPrimaryExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"time",
                      							lv_time_8_0,
                      							"ru.iaie.reflex.Reflex.TIME");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalReflex.g:3027:3: (otherlv_9= '(' ( (lv_nestedExpr_10_0= ruleExpression ) ) otherlv_11= ')' )
                    {
                    // InternalReflex.g:3027:3: (otherlv_9= '(' ( (lv_nestedExpr_10_0= ruleExpression ) ) otherlv_11= ')' )
                    // InternalReflex.g:3028:4: otherlv_9= '(' ( (lv_nestedExpr_10_0= ruleExpression ) ) otherlv_11= ')'
                    {
                    otherlv_9=(Token)match(input,56,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_5_0());
                      			
                    }
                    // InternalReflex.g:3032:4: ( (lv_nestedExpr_10_0= ruleExpression ) )
                    // InternalReflex.g:3033:5: (lv_nestedExpr_10_0= ruleExpression )
                    {
                    // InternalReflex.g:3033:5: (lv_nestedExpr_10_0= ruleExpression )
                    // InternalReflex.g:3034:6: lv_nestedExpr_10_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNestedExprExpressionParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_31);
                    lv_nestedExpr_10_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"nestedExpr",
                      							lv_nestedExpr_10_0,
                      							"ru.iaie.reflex.Reflex.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_11=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_5_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimaryExpression"


    // $ANTLR start "entryRuleUnaryExpression"
    // InternalReflex.g:3060:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalReflex.g:3060:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalReflex.g:3061:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnaryExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleUnaryExpression=ruleUnaryExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnaryExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnaryExpression"


    // $ANTLR start "ruleUnaryExpression"
    // InternalReflex.g:3067:1: ruleUnaryExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) ) ) ) ;
    public final EObject ruleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpression_0 = null;

        EObject this_FunctionCall_1 = null;

        EObject this_PostfixOp_2 = null;

        EObject this_InfixOp_3 = null;

        Enumerator lv_unaryOp_4_0 = null;

        EObject lv_right_5_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3073:2: ( (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) ) ) ) )
            // InternalReflex.g:3074:2: (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) ) ) )
            {
            // InternalReflex.g:3074:2: (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) ) ) )
            int alt37=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                switch ( input.LA(2) ) {
                case 79:
                case 80:
                    {
                    alt37=3;
                    }
                    break;
                case 56:
                    {
                    alt37=2;
                    }
                    break;
                case EOF:
                case RULE_BIT_AND:
                case RULE_BIT_XOR:
                case RULE_BIT_OR:
                case RULE_LOGICAL_AND:
                case RULE_LOGICAL_OR:
                case 43:
                case 45:
                case 49:
                case 52:
                case 57:
                case 90:
                case 91:
                case 94:
                case 95:
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                    {
                    alt37=1;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 1, input);

                    throw nvae;
                }

                }
                break;
            case RULE_INTEGER:
            case RULE_TIME:
            case RULE_FLOAT:
            case RULE_BOOL_LITERAL:
            case 56:
                {
                alt37=1;
                }
                break;
            case 79:
            case 80:
                {
                alt37=4;
                }
                break;
            case 90:
            case 91:
            case 92:
            case 93:
                {
                alt37=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // InternalReflex.g:3075:3: this_PrimaryExpression_0= rulePrimaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getPrimaryExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PrimaryExpression_0=rulePrimaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PrimaryExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:3084:3: this_FunctionCall_1= ruleFunctionCall
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getFunctionCallParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FunctionCall_1=ruleFunctionCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FunctionCall_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalReflex.g:3093:3: this_PostfixOp_2= rulePostfixOp
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getPostfixOpParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PostfixOp_2=rulePostfixOp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PostfixOp_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalReflex.g:3102:3: this_InfixOp_3= ruleInfixOp
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getUnaryExpressionAccess().getInfixOpParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_InfixOp_3=ruleInfixOp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_InfixOp_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalReflex.g:3111:3: ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) ) )
                    {
                    // InternalReflex.g:3111:3: ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) ) )
                    // InternalReflex.g:3112:4: ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) )
                    {
                    // InternalReflex.g:3112:4: ( (lv_unaryOp_4_0= ruleUnaryOp ) )
                    // InternalReflex.g:3113:5: (lv_unaryOp_4_0= ruleUnaryOp )
                    {
                    // InternalReflex.g:3113:5: (lv_unaryOp_4_0= ruleUnaryOp )
                    // InternalReflex.g:3114:6: lv_unaryOp_4_0= ruleUnaryOp
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnaryExpressionAccess().getUnaryOpUnaryOpEnumRuleCall_4_0_0());
                      					
                    }
                    pushFollow(FOLLOW_29);
                    lv_unaryOp_4_0=ruleUnaryOp();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"unaryOp",
                      							lv_unaryOp_4_0,
                      							"ru.iaie.reflex.Reflex.UnaryOp");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalReflex.g:3131:4: ( (lv_right_5_0= ruleCastExpression ) )
                    // InternalReflex.g:3132:5: (lv_right_5_0= ruleCastExpression )
                    {
                    // InternalReflex.g:3132:5: (lv_right_5_0= ruleCastExpression )
                    // InternalReflex.g:3133:6: lv_right_5_0= ruleCastExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnaryExpressionAccess().getRightCastExpressionParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_5_0=ruleCastExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getUnaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_5_0,
                      							"ru.iaie.reflex.Reflex.CastExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryExpression"


    // $ANTLR start "entryRuleCastExpression"
    // InternalReflex.g:3155:1: entryRuleCastExpression returns [EObject current=null] : iv_ruleCastExpression= ruleCastExpression EOF ;
    public final EObject entryRuleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastExpression = null;


        try {
            // InternalReflex.g:3155:55: (iv_ruleCastExpression= ruleCastExpression EOF )
            // InternalReflex.g:3156:2: iv_ruleCastExpression= ruleCastExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCastExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCastExpression=ruleCastExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCastExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCastExpression"


    // $ANTLR start "ruleCastExpression"
    // InternalReflex.g:3162:1: ruleCastExpression returns [EObject current=null] : (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) ) ;
    public final EObject ruleCastExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_UnaryExpression_0 = null;

        Enumerator lv_type_2_0 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3168:2: ( (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) ) )
            // InternalReflex.g:3169:2: (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) )
            {
            // InternalReflex.g:3169:2: (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=RULE_ID && LA38_0<=RULE_TIME)||(LA38_0>=RULE_FLOAT && LA38_0<=RULE_BOOL_LITERAL)||(LA38_0>=79 && LA38_0<=80)||(LA38_0>=90 && LA38_0<=93)) ) {
                alt38=1;
            }
            else if ( (LA38_0==56) ) {
                int LA38_2 = input.LA(2);

                if ( ((LA38_2>=RULE_ID && LA38_2<=RULE_TIME)||(LA38_2>=RULE_FLOAT && LA38_2<=RULE_BOOL_LITERAL)||LA38_2==46||LA38_2==56||(LA38_2>=79 && LA38_2<=80)||(LA38_2>=90 && LA38_2<=93)) ) {
                    alt38=1;
                }
                else if ( ((LA38_2>=105 && LA38_2<=117)) ) {
                    alt38=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalReflex.g:3170:3: this_UnaryExpression_0= ruleUnaryExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCastExpressionAccess().getUnaryExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_UnaryExpression_0=ruleUnaryExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_UnaryExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:3179:3: (otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) )
                    {
                    // InternalReflex.g:3179:3: (otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) )
                    // InternalReflex.g:3180:4: otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) )
                    {
                    otherlv_1=(Token)match(input,56,FOLLOW_33); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getCastExpressionAccess().getLeftParenthesisKeyword_1_0());
                      			
                    }
                    // InternalReflex.g:3184:4: ( (lv_type_2_0= ruleType ) )
                    // InternalReflex.g:3185:5: (lv_type_2_0= ruleType )
                    {
                    // InternalReflex.g:3185:5: (lv_type_2_0= ruleType )
                    // InternalReflex.g:3186:6: lv_type_2_0= ruleType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCastExpressionAccess().getTypeTypeEnumRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_31);
                    lv_type_2_0=ruleType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCastExpressionRule());
                      						}
                      						set(
                      							current,
                      							"type",
                      							lv_type_2_0,
                      							"ru.iaie.reflex.Reflex.Type");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,57,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getCastExpressionAccess().getRightParenthesisKeyword_1_2());
                      			
                    }
                    // InternalReflex.g:3207:4: ( (lv_right_4_0= ruleCastExpression ) )
                    // InternalReflex.g:3208:5: (lv_right_4_0= ruleCastExpression )
                    {
                    // InternalReflex.g:3208:5: (lv_right_4_0= ruleCastExpression )
                    // InternalReflex.g:3209:6: lv_right_4_0= ruleCastExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCastExpressionAccess().getRightCastExpressionParserRuleCall_1_3_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_4_0=ruleCastExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCastExpressionRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_4_0,
                      							"ru.iaie.reflex.Reflex.CastExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCastExpression"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // InternalReflex.g:3231:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalReflex.g:3231:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalReflex.g:3232:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // InternalReflex.g:3238:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_CastExpression_0 = null;

        Enumerator lv_mulOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3244:2: ( (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* ) )
            // InternalReflex.g:3245:2: (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* )
            {
            // InternalReflex.g:3245:2: (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* )
            // InternalReflex.g:3246:3: this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getCastExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_52);
            this_CastExpression_0=ruleCastExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CastExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3254:3: ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( ((LA39_0>=102 && LA39_0<=104)) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalReflex.g:3255:4: () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) )
            	    {
            	    // InternalReflex.g:3255:4: ()
            	    // InternalReflex.g:3256:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getMultiplicativeExpressionAccess().getMultiplicativeExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:3262:4: ( (lv_mulOp_2_0= ruleMultiplicativeOp ) )
            	    // InternalReflex.g:3263:5: (lv_mulOp_2_0= ruleMultiplicativeOp )
            	    {
            	    // InternalReflex.g:3263:5: (lv_mulOp_2_0= ruleMultiplicativeOp )
            	    // InternalReflex.g:3264:6: lv_mulOp_2_0= ruleMultiplicativeOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getMulOpMultiplicativeOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_29);
            	    lv_mulOp_2_0=ruleMultiplicativeOp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"mulOp",
            	      							lv_mulOp_2_0,
            	      							"ru.iaie.reflex.Reflex.MultiplicativeOp");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalReflex.g:3281:4: ( (lv_right_3_0= ruleCastExpression ) )
            	    // InternalReflex.g:3282:5: (lv_right_3_0= ruleCastExpression )
            	    {
            	    // InternalReflex.g:3282:5: (lv_right_3_0= ruleCastExpression )
            	    // InternalReflex.g:3283:6: lv_right_3_0= ruleCastExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightCastExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_52);
            	    lv_right_3_0=ruleCastExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.CastExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop39;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleAdditiveExpression"
    // InternalReflex.g:3305:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalReflex.g:3305:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalReflex.g:3306:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // InternalReflex.g:3312:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MultiplicativeExpression_0 = null;

        Enumerator lv_addOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3318:2: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) )
            // InternalReflex.g:3319:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            {
            // InternalReflex.g:3319:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            // InternalReflex.g:3320:3: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_53);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_MultiplicativeExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3328:3: ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==90) ) {
                    alt40=1;
                }
                else if ( (LA40_0==91) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalReflex.g:3329:4: () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    {
            	    // InternalReflex.g:3329:4: ()
            	    // InternalReflex.g:3330:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAdditiveExpressionAccess().getAdditiveExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:3336:4: ( (lv_addOp_2_0= ruleAdditiveOp ) )
            	    // InternalReflex.g:3337:5: (lv_addOp_2_0= ruleAdditiveOp )
            	    {
            	    // InternalReflex.g:3337:5: (lv_addOp_2_0= ruleAdditiveOp )
            	    // InternalReflex.g:3338:6: lv_addOp_2_0= ruleAdditiveOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getAddOpAdditiveOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_29);
            	    lv_addOp_2_0=ruleAdditiveOp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"addOp",
            	      							lv_addOp_2_0,
            	      							"ru.iaie.reflex.Reflex.AdditiveOp");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalReflex.g:3355:4: ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    // InternalReflex.g:3356:5: (lv_right_3_0= ruleAdditiveExpression )
            	    {
            	    // InternalReflex.g:3356:5: (lv_right_3_0= ruleAdditiveExpression )
            	    // InternalReflex.g:3357:6: lv_right_3_0= ruleAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_53);
            	    lv_right_3_0=ruleAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.AdditiveExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleShiftExpression"
    // InternalReflex.g:3379:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // InternalReflex.g:3379:56: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // InternalReflex.g:3380:2: iv_ruleShiftExpression= ruleShiftExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getShiftExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleShiftExpression=ruleShiftExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleShiftExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleShiftExpression"


    // $ANTLR start "ruleShiftExpression"
    // InternalReflex.g:3386:1: ruleShiftExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AdditiveExpression_0 = null;

        Enumerator lv_shiftOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3392:2: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* ) )
            // InternalReflex.g:3393:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* )
            {
            // InternalReflex.g:3393:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* )
            // InternalReflex.g:3394:3: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getShiftExpressionAccess().getAdditiveExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_54);
            this_AdditiveExpression_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AdditiveExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3402:3: ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==100) ) {
                    alt41=1;
                }
                else if ( (LA41_0==101) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalReflex.g:3403:4: () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) )
            	    {
            	    // InternalReflex.g:3403:4: ()
            	    // InternalReflex.g:3404:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getShiftExpressionAccess().getShiftExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:3410:4: ( (lv_shiftOp_2_0= ruleShiftOp ) )
            	    // InternalReflex.g:3411:5: (lv_shiftOp_2_0= ruleShiftOp )
            	    {
            	    // InternalReflex.g:3411:5: (lv_shiftOp_2_0= ruleShiftOp )
            	    // InternalReflex.g:3412:6: lv_shiftOp_2_0= ruleShiftOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getShiftExpressionAccess().getShiftOpShiftOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_29);
            	    lv_shiftOp_2_0=ruleShiftOp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"shiftOp",
            	      							lv_shiftOp_2_0,
            	      							"ru.iaie.reflex.Reflex.ShiftOp");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalReflex.g:3429:4: ( (lv_right_3_0= ruleShiftExpression ) )
            	    // InternalReflex.g:3430:5: (lv_right_3_0= ruleShiftExpression )
            	    {
            	    // InternalReflex.g:3430:5: (lv_right_3_0= ruleShiftExpression )
            	    // InternalReflex.g:3431:6: lv_right_3_0= ruleShiftExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getShiftExpressionAccess().getRightShiftExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_54);
            	    lv_right_3_0=ruleShiftExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getShiftExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.ShiftExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShiftExpression"


    // $ANTLR start "entryRuleCompareExpression"
    // InternalReflex.g:3453:1: entryRuleCompareExpression returns [EObject current=null] : iv_ruleCompareExpression= ruleCompareExpression EOF ;
    public final EObject entryRuleCompareExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompareExpression = null;


        try {
            // InternalReflex.g:3453:58: (iv_ruleCompareExpression= ruleCompareExpression EOF )
            // InternalReflex.g:3454:2: iv_ruleCompareExpression= ruleCompareExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCompareExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCompareExpression=ruleCompareExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCompareExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompareExpression"


    // $ANTLR start "ruleCompareExpression"
    // InternalReflex.g:3460:1: ruleCompareExpression returns [EObject current=null] : (this_CheckStateExpression_0= ruleCheckStateExpression | (this_ShiftExpression_1= ruleShiftExpression ( () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) ) )* ) ) ;
    public final EObject ruleCompareExpression() throws RecognitionException {
        EObject current = null;

        EObject this_CheckStateExpression_0 = null;

        EObject this_ShiftExpression_1 = null;

        Enumerator lv_cmpOp_3_0 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3466:2: ( (this_CheckStateExpression_0= ruleCheckStateExpression | (this_ShiftExpression_1= ruleShiftExpression ( () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) ) )* ) ) )
            // InternalReflex.g:3467:2: (this_CheckStateExpression_0= ruleCheckStateExpression | (this_ShiftExpression_1= ruleShiftExpression ( () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) ) )* ) )
            {
            // InternalReflex.g:3467:2: (this_CheckStateExpression_0= ruleCheckStateExpression | (this_ShiftExpression_1= ruleShiftExpression ( () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) ) )* ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==46) ) {
                alt43=1;
            }
            else if ( ((LA43_0>=RULE_ID && LA43_0<=RULE_TIME)||(LA43_0>=RULE_FLOAT && LA43_0<=RULE_BOOL_LITERAL)||LA43_0==56||(LA43_0>=79 && LA43_0<=80)||(LA43_0>=90 && LA43_0<=93)) ) {
                alt43=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // InternalReflex.g:3468:3: this_CheckStateExpression_0= ruleCheckStateExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getCompareExpressionAccess().getCheckStateExpressionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_CheckStateExpression_0=ruleCheckStateExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_CheckStateExpression_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:3477:3: (this_ShiftExpression_1= ruleShiftExpression ( () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) ) )* )
                    {
                    // InternalReflex.g:3477:3: (this_ShiftExpression_1= ruleShiftExpression ( () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) ) )* )
                    // InternalReflex.g:3478:4: this_ShiftExpression_1= ruleShiftExpression ( () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) ) )*
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getCompareExpressionAccess().getShiftExpressionParserRuleCall_1_0());
                      			
                    }
                    pushFollow(FOLLOW_55);
                    this_ShiftExpression_1=ruleShiftExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_ShiftExpression_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalReflex.g:3486:4: ( () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) ) )*
                    loop42:
                    do {
                        int alt42=2;
                        switch ( input.LA(1) ) {
                        case 94:
                            {
                            alt42=1;
                            }
                            break;
                        case 95:
                            {
                            alt42=1;
                            }
                            break;
                        case 96:
                            {
                            alt42=1;
                            }
                            break;
                        case 97:
                            {
                            alt42=1;
                            }
                            break;

                        }

                        switch (alt42) {
                    	case 1 :
                    	    // InternalReflex.g:3487:5: () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) )
                    	    {
                    	    // InternalReflex.g:3487:5: ()
                    	    // InternalReflex.g:3488:6: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						current = forceCreateModelElementAndSet(
                    	      							grammarAccess.getCompareExpressionAccess().getCompareExpressionLeftAction_1_1_0(),
                    	      							current);
                    	      					
                    	    }

                    	    }

                    	    // InternalReflex.g:3494:5: ( (lv_cmpOp_3_0= ruleCompareOp ) )
                    	    // InternalReflex.g:3495:6: (lv_cmpOp_3_0= ruleCompareOp )
                    	    {
                    	    // InternalReflex.g:3495:6: (lv_cmpOp_3_0= ruleCompareOp )
                    	    // InternalReflex.g:3496:7: lv_cmpOp_3_0= ruleCompareOp
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getCompareExpressionAccess().getCmpOpCompareOpEnumRuleCall_1_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_29);
                    	    lv_cmpOp_3_0=ruleCompareOp();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getCompareExpressionRule());
                    	      							}
                    	      							set(
                    	      								current,
                    	      								"cmpOp",
                    	      								lv_cmpOp_3_0,
                    	      								"ru.iaie.reflex.Reflex.CompareOp");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }

                    	    // InternalReflex.g:3513:5: ( (lv_right_4_0= ruleCompareExpression ) )
                    	    // InternalReflex.g:3514:6: (lv_right_4_0= ruleCompareExpression )
                    	    {
                    	    // InternalReflex.g:3514:6: (lv_right_4_0= ruleCompareExpression )
                    	    // InternalReflex.g:3515:7: lv_right_4_0= ruleCompareExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getCompareExpressionAccess().getRightCompareExpressionParserRuleCall_1_1_2_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_55);
                    	    lv_right_4_0=ruleCompareExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getCompareExpressionRule());
                    	      							}
                    	      							set(
                    	      								current,
                    	      								"right",
                    	      								lv_right_4_0,
                    	      								"ru.iaie.reflex.Reflex.CompareExpression");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop42;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompareExpression"


    // $ANTLR start "entryRuleEqualityExpression"
    // InternalReflex.g:3538:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalReflex.g:3538:59: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalReflex.g:3539:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEqualityExpression"


    // $ANTLR start "ruleEqualityExpression"
    // InternalReflex.g:3545:1: ruleEqualityExpression returns [EObject current=null] : (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_CompareExpression_0 = null;

        Enumerator lv_eqCmpOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3551:2: ( (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) )
            // InternalReflex.g:3552:2: (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            {
            // InternalReflex.g:3552:2: (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            // InternalReflex.g:3553:3: this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEqualityExpressionAccess().getCompareExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_56);
            this_CompareExpression_0=ruleCompareExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CompareExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3561:3: ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==98) ) {
                    alt44=1;
                }
                else if ( (LA44_0==99) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalReflex.g:3562:4: () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) )
            	    {
            	    // InternalReflex.g:3562:4: ()
            	    // InternalReflex.g:3563:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getEqualityExpressionAccess().getEqualityExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:3569:4: ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) )
            	    // InternalReflex.g:3570:5: (lv_eqCmpOp_2_0= ruleCompareEqOp )
            	    {
            	    // InternalReflex.g:3570:5: (lv_eqCmpOp_2_0= ruleCompareEqOp )
            	    // InternalReflex.g:3571:6: lv_eqCmpOp_2_0= ruleCompareEqOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEqualityExpressionAccess().getEqCmpOpCompareEqOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_29);
            	    lv_eqCmpOp_2_0=ruleCompareEqOp();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"eqCmpOp",
            	      							lv_eqCmpOp_2_0,
            	      							"ru.iaie.reflex.Reflex.CompareEqOp");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }

            	    // InternalReflex.g:3588:4: ( (lv_right_3_0= ruleEqualityExpression ) )
            	    // InternalReflex.g:3589:5: (lv_right_3_0= ruleEqualityExpression )
            	    {
            	    // InternalReflex.g:3589:5: (lv_right_3_0= ruleEqualityExpression )
            	    // InternalReflex.g:3590:6: lv_right_3_0= ruleEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightEqualityExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_56);
            	    lv_right_3_0=ruleEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.EqualityExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEqualityExpression"


    // $ANTLR start "entryRuleBitAndExpression"
    // InternalReflex.g:3612:1: entryRuleBitAndExpression returns [EObject current=null] : iv_ruleBitAndExpression= ruleBitAndExpression EOF ;
    public final EObject entryRuleBitAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitAndExpression = null;


        try {
            // InternalReflex.g:3612:57: (iv_ruleBitAndExpression= ruleBitAndExpression EOF )
            // InternalReflex.g:3613:2: iv_ruleBitAndExpression= ruleBitAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitAndExpression=ruleBitAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitAndExpression"


    // $ANTLR start "ruleBitAndExpression"
    // InternalReflex.g:3619:1: ruleBitAndExpression returns [EObject current=null] : (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* ) ;
    public final EObject ruleBitAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_BIT_AND_2=null;
        EObject this_EqualityExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3625:2: ( (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* ) )
            // InternalReflex.g:3626:2: (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* )
            {
            // InternalReflex.g:3626:2: (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* )
            // InternalReflex.g:3627:3: this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitAndExpressionAccess().getEqualityExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_57);
            this_EqualityExpression_0=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_EqualityExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3635:3: ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==RULE_BIT_AND) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalReflex.g:3636:4: () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) )
            	    {
            	    // InternalReflex.g:3636:4: ()
            	    // InternalReflex.g:3637:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitAndExpressionAccess().getBitAndExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_BIT_AND_2=(Token)match(input,RULE_BIT_AND,FOLLOW_29); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_BIT_AND_2, grammarAccess.getBitAndExpressionAccess().getBIT_ANDTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:3647:4: ( (lv_right_3_0= ruleBitAndExpression ) )
            	    // InternalReflex.g:3648:5: (lv_right_3_0= ruleBitAndExpression )
            	    {
            	    // InternalReflex.g:3648:5: (lv_right_3_0= ruleBitAndExpression )
            	    // InternalReflex.g:3649:6: lv_right_3_0= ruleBitAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitAndExpressionAccess().getRightBitAndExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_57);
            	    lv_right_3_0=ruleBitAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBitAndExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.BitAndExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitAndExpression"


    // $ANTLR start "entryRuleBitXorExpression"
    // InternalReflex.g:3671:1: entryRuleBitXorExpression returns [EObject current=null] : iv_ruleBitXorExpression= ruleBitXorExpression EOF ;
    public final EObject entryRuleBitXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitXorExpression = null;


        try {
            // InternalReflex.g:3671:57: (iv_ruleBitXorExpression= ruleBitXorExpression EOF )
            // InternalReflex.g:3672:2: iv_ruleBitXorExpression= ruleBitXorExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitXorExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitXorExpression=ruleBitXorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitXorExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitXorExpression"


    // $ANTLR start "ruleBitXorExpression"
    // InternalReflex.g:3678:1: ruleBitXorExpression returns [EObject current=null] : (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* ) ;
    public final EObject ruleBitXorExpression() throws RecognitionException {
        EObject current = null;

        Token this_BIT_XOR_2=null;
        EObject this_BitAndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3684:2: ( (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* ) )
            // InternalReflex.g:3685:2: (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* )
            {
            // InternalReflex.g:3685:2: (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* )
            // InternalReflex.g:3686:3: this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitXorExpressionAccess().getBitAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_58);
            this_BitAndExpression_0=ruleBitAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3694:3: ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==RULE_BIT_XOR) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalReflex.g:3695:4: () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) )
            	    {
            	    // InternalReflex.g:3695:4: ()
            	    // InternalReflex.g:3696:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitXorExpressionAccess().getBitXorExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_BIT_XOR_2=(Token)match(input,RULE_BIT_XOR,FOLLOW_29); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_BIT_XOR_2, grammarAccess.getBitXorExpressionAccess().getBIT_XORTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:3706:4: ( (lv_right_3_0= ruleBitXorExpression ) )
            	    // InternalReflex.g:3707:5: (lv_right_3_0= ruleBitXorExpression )
            	    {
            	    // InternalReflex.g:3707:5: (lv_right_3_0= ruleBitXorExpression )
            	    // InternalReflex.g:3708:6: lv_right_3_0= ruleBitXorExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitXorExpressionAccess().getRightBitXorExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_58);
            	    lv_right_3_0=ruleBitXorExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBitXorExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.BitXorExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitXorExpression"


    // $ANTLR start "entryRuleBitOrExpression"
    // InternalReflex.g:3730:1: entryRuleBitOrExpression returns [EObject current=null] : iv_ruleBitOrExpression= ruleBitOrExpression EOF ;
    public final EObject entryRuleBitOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitOrExpression = null;


        try {
            // InternalReflex.g:3730:56: (iv_ruleBitOrExpression= ruleBitOrExpression EOF )
            // InternalReflex.g:3731:2: iv_ruleBitOrExpression= ruleBitOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBitOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBitOrExpression=ruleBitOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBitOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBitOrExpression"


    // $ANTLR start "ruleBitOrExpression"
    // InternalReflex.g:3737:1: ruleBitOrExpression returns [EObject current=null] : (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* ) ;
    public final EObject ruleBitOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_BIT_OR_2=null;
        EObject this_BitXorExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3743:2: ( (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* ) )
            // InternalReflex.g:3744:2: (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* )
            {
            // InternalReflex.g:3744:2: (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* )
            // InternalReflex.g:3745:3: this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitOrExpressionAccess().getBitXorExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_59);
            this_BitXorExpression_0=ruleBitXorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitXorExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3753:3: ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==RULE_BIT_OR) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalReflex.g:3754:4: () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) )
            	    {
            	    // InternalReflex.g:3754:4: ()
            	    // InternalReflex.g:3755:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitOrExpressionAccess().getBitOrExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_BIT_OR_2=(Token)match(input,RULE_BIT_OR,FOLLOW_29); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_BIT_OR_2, grammarAccess.getBitOrExpressionAccess().getBIT_ORTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:3765:4: ( (lv_right_3_0= ruleBitOrExpression ) )
            	    // InternalReflex.g:3766:5: (lv_right_3_0= ruleBitOrExpression )
            	    {
            	    // InternalReflex.g:3766:5: (lv_right_3_0= ruleBitOrExpression )
            	    // InternalReflex.g:3767:6: lv_right_3_0= ruleBitOrExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitOrExpressionAccess().getRightBitOrExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_59);
            	    lv_right_3_0=ruleBitOrExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getBitOrExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.BitOrExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBitOrExpression"


    // $ANTLR start "entryRuleLogicalAndExpression"
    // InternalReflex.g:3789:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // InternalReflex.g:3789:61: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // InternalReflex.g:3790:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalAndExpression=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalAndExpression"


    // $ANTLR start "ruleLogicalAndExpression"
    // InternalReflex.g:3796:1: ruleLogicalAndExpression returns [EObject current=null] : (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_LOGICAL_AND_2=null;
        EObject this_BitOrExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3802:2: ( (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* ) )
            // InternalReflex.g:3803:2: (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* )
            {
            // InternalReflex.g:3803:2: (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* )
            // InternalReflex.g:3804:3: this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getBitOrExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_60);
            this_BitOrExpression_0=ruleBitOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitOrExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3812:3: ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==RULE_LOGICAL_AND) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalReflex.g:3813:4: () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) )
            	    {
            	    // InternalReflex.g:3813:4: ()
            	    // InternalReflex.g:3814:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_LOGICAL_AND_2=(Token)match(input,RULE_LOGICAL_AND,FOLLOW_29); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_LOGICAL_AND_2, grammarAccess.getLogicalAndExpressionAccess().getLOGICAL_ANDTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:3824:4: ( (lv_right_3_0= ruleLogicalAndExpression ) )
            	    // InternalReflex.g:3825:5: (lv_right_3_0= ruleLogicalAndExpression )
            	    {
            	    // InternalReflex.g:3825:5: (lv_right_3_0= ruleLogicalAndExpression )
            	    // InternalReflex.g:3826:6: lv_right_3_0= ruleLogicalAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getRightLogicalAndExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_60);
            	    lv_right_3_0=ruleLogicalAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLogicalAndExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.LogicalAndExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop48;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalAndExpression"


    // $ANTLR start "entryRuleLogicalOrExpression"
    // InternalReflex.g:3848:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // InternalReflex.g:3848:60: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // InternalReflex.g:3849:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLogicalOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLogicalOrExpression=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLogicalOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLogicalOrExpression"


    // $ANTLR start "ruleLogicalOrExpression"
    // InternalReflex.g:3855:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_LOGICAL_OR_2=null;
        EObject this_LogicalAndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3861:2: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* ) )
            // InternalReflex.g:3862:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* )
            {
            // InternalReflex.g:3862:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* )
            // InternalReflex.g:3863:3: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_61);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LogicalAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3871:3: ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==RULE_LOGICAL_OR) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalReflex.g:3872:4: () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) )
            	    {
            	    // InternalReflex.g:3872:4: ()
            	    // InternalReflex.g:3873:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_LOGICAL_OR_2=(Token)match(input,RULE_LOGICAL_OR,FOLLOW_29); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_LOGICAL_OR_2, grammarAccess.getLogicalOrExpressionAccess().getLOGICAL_ORTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:3883:4: ( (lv_right_3_0= ruleLogicalOrExpression ) )
            	    // InternalReflex.g:3884:5: (lv_right_3_0= ruleLogicalOrExpression )
            	    {
            	    // InternalReflex.g:3884:5: (lv_right_3_0= ruleLogicalOrExpression )
            	    // InternalReflex.g:3885:6: lv_right_3_0= ruleLogicalOrExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getRightLogicalOrExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_61);
            	    lv_right_3_0=ruleLogicalOrExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getLogicalOrExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"ru.iaie.reflex.Reflex.LogicalOrExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop49;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLogicalOrExpression"


    // $ANTLR start "entryRuleAssignmentExpression"
    // InternalReflex.g:3907:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression = null;


        try {
            // InternalReflex.g:3907:61: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // InternalReflex.g:3908:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignmentExpression=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentExpression"


    // $ANTLR start "ruleAssignmentExpression"
    // InternalReflex.g:3914:1: ruleAssignmentExpression returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) ) )? ( (lv_expr_2_0= ruleLogicalOrExpression ) ) ) ;
    public final EObject ruleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Enumerator lv_assignOp_1_0 = null;

        EObject lv_expr_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3920:2: ( ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) ) )? ( (lv_expr_2_0= ruleLogicalOrExpression ) ) ) )
            // InternalReflex.g:3921:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) ) )? ( (lv_expr_2_0= ruleLogicalOrExpression ) ) )
            {
            // InternalReflex.g:3921:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) ) )? ( (lv_expr_2_0= ruleLogicalOrExpression ) ) )
            // InternalReflex.g:3922:3: ( ( (otherlv_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) ) )? ( (lv_expr_2_0= ruleLogicalOrExpression ) )
            {
            // InternalReflex.g:3922:3: ( ( (otherlv_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) ) )?
            int alt50=2;
            int LA50_0 = input.LA(1);

            if ( (LA50_0==RULE_ID) ) {
                int LA50_1 = input.LA(2);

                if ( (LA50_1==54||(LA50_1>=81 && LA50_1<=89)) ) {
                    alt50=1;
                }
            }
            switch (alt50) {
                case 1 :
                    // InternalReflex.g:3923:4: ( (otherlv_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) )
                    {
                    // InternalReflex.g:3923:4: ( (otherlv_0= RULE_ID ) )
                    // InternalReflex.g:3924:5: (otherlv_0= RULE_ID )
                    {
                    // InternalReflex.g:3924:5: (otherlv_0= RULE_ID )
                    // InternalReflex.g:3925:6: otherlv_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAssignmentExpressionRule());
                      						}
                      					
                    }
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_62); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_0, grammarAccess.getAssignmentExpressionAccess().getAssignVarIdReferenceCrossReference_0_0_0());
                      					
                    }

                    }


                    }

                    // InternalReflex.g:3936:4: ( (lv_assignOp_1_0= ruleAssignOperator ) )
                    // InternalReflex.g:3937:5: (lv_assignOp_1_0= ruleAssignOperator )
                    {
                    // InternalReflex.g:3937:5: (lv_assignOp_1_0= ruleAssignOperator )
                    // InternalReflex.g:3938:6: lv_assignOp_1_0= ruleAssignOperator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getAssignOpAssignOperatorEnumRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_29);
                    lv_assignOp_1_0=ruleAssignOperator();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
                      						}
                      						set(
                      							current,
                      							"assignOp",
                      							lv_assignOp_1_0,
                      							"ru.iaie.reflex.Reflex.AssignOperator");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalReflex.g:3956:3: ( (lv_expr_2_0= ruleLogicalOrExpression ) )
            // InternalReflex.g:3957:4: (lv_expr_2_0= ruleLogicalOrExpression )
            {
            // InternalReflex.g:3957:4: (lv_expr_2_0= ruleLogicalOrExpression )
            // InternalReflex.g:3958:5: lv_expr_2_0= ruleLogicalOrExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getExprLogicalOrExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expr_2_0=ruleLogicalOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
              					}
              					set(
              						current,
              						"expr",
              						lv_expr_2_0,
              						"ru.iaie.reflex.Reflex.LogicalOrExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentExpression"


    // $ANTLR start "entryRuleExpression"
    // InternalReflex.g:3979:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalReflex.g:3979:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalReflex.g:3980:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalReflex.g:3986:1: ruleExpression returns [EObject current=null] : this_AssignmentExpression_0= ruleAssignmentExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AssignmentExpression_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3992:2: (this_AssignmentExpression_0= ruleAssignmentExpression )
            // InternalReflex.g:3993:2: this_AssignmentExpression_0= ruleAssignmentExpression
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getExpressionAccess().getAssignmentExpressionParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_AssignmentExpression_0=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_AssignmentExpression_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "rulePortType"
    // InternalReflex.g:4004:1: rulePortType returns [Enumerator current=null] : ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) ) ;
    public final Enumerator rulePortType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4010:2: ( ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) ) )
            // InternalReflex.g:4011:2: ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) )
            {
            // InternalReflex.g:4011:2: ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==75) ) {
                alt51=1;
            }
            else if ( (LA51_0==76) ) {
                alt51=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }
            switch (alt51) {
                case 1 :
                    // InternalReflex.g:4012:3: (enumLiteral_0= 'input' )
                    {
                    // InternalReflex.g:4012:3: (enumLiteral_0= 'input' )
                    // InternalReflex.g:4013:4: enumLiteral_0= 'input'
                    {
                    enumLiteral_0=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPortTypeAccess().getINPUTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getPortTypeAccess().getINPUTEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4020:3: (enumLiteral_1= 'output' )
                    {
                    // InternalReflex.g:4020:3: (enumLiteral_1= 'output' )
                    // InternalReflex.g:4021:4: enumLiteral_1= 'output'
                    {
                    enumLiteral_1=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPortTypeAccess().getOUTPUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getPortTypeAccess().getOUTPUTEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePortType"


    // $ANTLR start "ruleStateQualifier"
    // InternalReflex.g:4031:1: ruleStateQualifier returns [Enumerator current=null] : ( (enumLiteral_0= 'active' ) | (enumLiteral_1= 'inactive' ) | (enumLiteral_2= 'stop' ) | (enumLiteral_3= 'error' ) ) ;
    public final Enumerator ruleStateQualifier() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalReflex.g:4037:2: ( ( (enumLiteral_0= 'active' ) | (enumLiteral_1= 'inactive' ) | (enumLiteral_2= 'stop' ) | (enumLiteral_3= 'error' ) ) )
            // InternalReflex.g:4038:2: ( (enumLiteral_0= 'active' ) | (enumLiteral_1= 'inactive' ) | (enumLiteral_2= 'stop' ) | (enumLiteral_3= 'error' ) )
            {
            // InternalReflex.g:4038:2: ( (enumLiteral_0= 'active' ) | (enumLiteral_1= 'inactive' ) | (enumLiteral_2= 'stop' ) | (enumLiteral_3= 'error' ) )
            int alt52=4;
            switch ( input.LA(1) ) {
            case 77:
                {
                alt52=1;
                }
                break;
            case 78:
                {
                alt52=2;
                }
                break;
            case 67:
                {
                alt52=3;
                }
                break;
            case 68:
                {
                alt52=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }

            switch (alt52) {
                case 1 :
                    // InternalReflex.g:4039:3: (enumLiteral_0= 'active' )
                    {
                    // InternalReflex.g:4039:3: (enumLiteral_0= 'active' )
                    // InternalReflex.g:4040:4: enumLiteral_0= 'active'
                    {
                    enumLiteral_0=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getStateQualifierAccess().getACTIVEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getStateQualifierAccess().getACTIVEEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4047:3: (enumLiteral_1= 'inactive' )
                    {
                    // InternalReflex.g:4047:3: (enumLiteral_1= 'inactive' )
                    // InternalReflex.g:4048:4: enumLiteral_1= 'inactive'
                    {
                    enumLiteral_1=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getStateQualifierAccess().getINACTIVEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getStateQualifierAccess().getINACTIVEEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4055:3: (enumLiteral_2= 'stop' )
                    {
                    // InternalReflex.g:4055:3: (enumLiteral_2= 'stop' )
                    // InternalReflex.g:4056:4: enumLiteral_2= 'stop'
                    {
                    enumLiteral_2=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getStateQualifierAccess().getSTOPEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getStateQualifierAccess().getSTOPEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:4063:3: (enumLiteral_3= 'error' )
                    {
                    // InternalReflex.g:4063:3: (enumLiteral_3= 'error' )
                    // InternalReflex.g:4064:4: enumLiteral_3= 'error'
                    {
                    enumLiteral_3=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getStateQualifierAccess().getERROREnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getStateQualifierAccess().getERROREnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStateQualifier"


    // $ANTLR start "ruleInfixPostfixOp"
    // InternalReflex.g:4074:1: ruleInfixPostfixOp returns [Enumerator current=null] : ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) ) ;
    public final Enumerator ruleInfixPostfixOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4080:2: ( ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) ) )
            // InternalReflex.g:4081:2: ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) )
            {
            // InternalReflex.g:4081:2: ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==79) ) {
                alt53=1;
            }
            else if ( (LA53_0==80) ) {
                alt53=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // InternalReflex.g:4082:3: (enumLiteral_0= '++' )
                    {
                    // InternalReflex.g:4082:3: (enumLiteral_0= '++' )
                    // InternalReflex.g:4083:4: enumLiteral_0= '++'
                    {
                    enumLiteral_0=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getInfixPostfixOpAccess().getINCEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getInfixPostfixOpAccess().getINCEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4090:3: (enumLiteral_1= '--' )
                    {
                    // InternalReflex.g:4090:3: (enumLiteral_1= '--' )
                    // InternalReflex.g:4091:4: enumLiteral_1= '--'
                    {
                    enumLiteral_1=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getInfixPostfixOpAccess().getDECEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getInfixPostfixOpAccess().getDECEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInfixPostfixOp"


    // $ANTLR start "ruleAssignOperator"
    // InternalReflex.g:4101:1: ruleAssignOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) ) ;
    public final Enumerator ruleAssignOperator() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;


        	enterRule();

        try {
            // InternalReflex.g:4107:2: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) ) )
            // InternalReflex.g:4108:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) )
            {
            // InternalReflex.g:4108:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) )
            int alt54=10;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt54=1;
                }
                break;
            case 81:
                {
                alt54=2;
                }
                break;
            case 82:
                {
                alt54=3;
                }
                break;
            case 83:
                {
                alt54=4;
                }
                break;
            case 84:
                {
                alt54=5;
                }
                break;
            case 85:
                {
                alt54=6;
                }
                break;
            case 86:
                {
                alt54=7;
                }
                break;
            case 87:
                {
                alt54=8;
                }
                break;
            case 88:
                {
                alt54=9;
                }
                break;
            case 89:
                {
                alt54=10;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 54, 0, input);

                throw nvae;
            }

            switch (alt54) {
                case 1 :
                    // InternalReflex.g:4109:3: (enumLiteral_0= '=' )
                    {
                    // InternalReflex.g:4109:3: (enumLiteral_0= '=' )
                    // InternalReflex.g:4110:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,54,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getASSIGNEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAssignOperatorAccess().getASSIGNEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4117:3: (enumLiteral_1= '*=' )
                    {
                    // InternalReflex.g:4117:3: (enumLiteral_1= '*=' )
                    // InternalReflex.g:4118:4: enumLiteral_1= '*='
                    {
                    enumLiteral_1=(Token)match(input,81,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getMULEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getAssignOperatorAccess().getMULEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4125:3: (enumLiteral_2= '/=' )
                    {
                    // InternalReflex.g:4125:3: (enumLiteral_2= '/=' )
                    // InternalReflex.g:4126:4: enumLiteral_2= '/='
                    {
                    enumLiteral_2=(Token)match(input,82,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getDIVEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getAssignOperatorAccess().getDIVEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:4133:3: (enumLiteral_3= '+=' )
                    {
                    // InternalReflex.g:4133:3: (enumLiteral_3= '+=' )
                    // InternalReflex.g:4134:4: enumLiteral_3= '+='
                    {
                    enumLiteral_3=(Token)match(input,83,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getMODEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getAssignOperatorAccess().getMODEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalReflex.g:4141:3: (enumLiteral_4= '-=' )
                    {
                    // InternalReflex.g:4141:3: (enumLiteral_4= '-=' )
                    // InternalReflex.g:4142:4: enumLiteral_4= '-='
                    {
                    enumLiteral_4=(Token)match(input,84,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getSUBEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getAssignOperatorAccess().getSUBEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalReflex.g:4149:3: (enumLiteral_5= '<<=' )
                    {
                    // InternalReflex.g:4149:3: (enumLiteral_5= '<<=' )
                    // InternalReflex.g:4150:4: enumLiteral_5= '<<='
                    {
                    enumLiteral_5=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getCINEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getAssignOperatorAccess().getCINEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalReflex.g:4157:3: (enumLiteral_6= '>>=' )
                    {
                    // InternalReflex.g:4157:3: (enumLiteral_6= '>>=' )
                    // InternalReflex.g:4158:4: enumLiteral_6= '>>='
                    {
                    enumLiteral_6=(Token)match(input,86,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getCOUTEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getAssignOperatorAccess().getCOUTEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalReflex.g:4165:3: (enumLiteral_7= '&=' )
                    {
                    // InternalReflex.g:4165:3: (enumLiteral_7= '&=' )
                    // InternalReflex.g:4166:4: enumLiteral_7= '&='
                    {
                    enumLiteral_7=(Token)match(input,87,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getBIT_ANDEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getAssignOperatorAccess().getBIT_ANDEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalReflex.g:4173:3: (enumLiteral_8= '^=' )
                    {
                    // InternalReflex.g:4173:3: (enumLiteral_8= '^=' )
                    // InternalReflex.g:4174:4: enumLiteral_8= '^='
                    {
                    enumLiteral_8=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getBIT_XOREnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getAssignOperatorAccess().getBIT_XOREnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalReflex.g:4181:3: (enumLiteral_9= '|=' )
                    {
                    // InternalReflex.g:4181:3: (enumLiteral_9= '|=' )
                    // InternalReflex.g:4182:4: enumLiteral_9= '|='
                    {
                    enumLiteral_9=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getBIT_OREnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_9, grammarAccess.getAssignOperatorAccess().getBIT_OREnumLiteralDeclaration_9());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignOperator"


    // $ANTLR start "ruleUnaryOp"
    // InternalReflex.g:4192:1: ruleUnaryOp returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) ) ;
    public final Enumerator ruleUnaryOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalReflex.g:4198:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) ) )
            // InternalReflex.g:4199:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) )
            {
            // InternalReflex.g:4199:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) )
            int alt55=4;
            switch ( input.LA(1) ) {
            case 90:
                {
                alt55=1;
                }
                break;
            case 91:
                {
                alt55=2;
                }
                break;
            case 92:
                {
                alt55=3;
                }
                break;
            case 93:
                {
                alt55=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }

            switch (alt55) {
                case 1 :
                    // InternalReflex.g:4200:3: (enumLiteral_0= '+' )
                    {
                    // InternalReflex.g:4200:3: (enumLiteral_0= '+' )
                    // InternalReflex.g:4201:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOpAccess().getPLUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getUnaryOpAccess().getPLUSEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4208:3: (enumLiteral_1= '-' )
                    {
                    // InternalReflex.g:4208:3: (enumLiteral_1= '-' )
                    // InternalReflex.g:4209:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOpAccess().getMINUSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getUnaryOpAccess().getMINUSEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4216:3: (enumLiteral_2= '~' )
                    {
                    // InternalReflex.g:4216:3: (enumLiteral_2= '~' )
                    // InternalReflex.g:4217:4: enumLiteral_2= '~'
                    {
                    enumLiteral_2=(Token)match(input,92,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOpAccess().getBIT_NOTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getUnaryOpAccess().getBIT_NOTEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:4224:3: (enumLiteral_3= '!' )
                    {
                    // InternalReflex.g:4224:3: (enumLiteral_3= '!' )
                    // InternalReflex.g:4225:4: enumLiteral_3= '!'
                    {
                    enumLiteral_3=(Token)match(input,93,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOpAccess().getLOGICAL_NOTEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getUnaryOpAccess().getLOGICAL_NOTEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnaryOp"


    // $ANTLR start "ruleCompareOp"
    // InternalReflex.g:4235:1: ruleCompareOp returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) ) ;
    public final Enumerator ruleCompareOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalReflex.g:4241:2: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) ) )
            // InternalReflex.g:4242:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) )
            {
            // InternalReflex.g:4242:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) )
            int alt56=4;
            switch ( input.LA(1) ) {
            case 94:
                {
                alt56=1;
                }
                break;
            case 95:
                {
                alt56=2;
                }
                break;
            case 96:
                {
                alt56=3;
                }
                break;
            case 97:
                {
                alt56=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }

            switch (alt56) {
                case 1 :
                    // InternalReflex.g:4243:3: (enumLiteral_0= '<' )
                    {
                    // InternalReflex.g:4243:3: (enumLiteral_0= '<' )
                    // InternalReflex.g:4244:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareOpAccess().getLESSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getCompareOpAccess().getLESSEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4251:3: (enumLiteral_1= '>' )
                    {
                    // InternalReflex.g:4251:3: (enumLiteral_1= '>' )
                    // InternalReflex.g:4252:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,95,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareOpAccess().getGREATEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getCompareOpAccess().getGREATEREnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4259:3: (enumLiteral_2= '=<' )
                    {
                    // InternalReflex.g:4259:3: (enumLiteral_2= '=<' )
                    // InternalReflex.g:4260:4: enumLiteral_2= '=<'
                    {
                    enumLiteral_2=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareOpAccess().getLESS_EQEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getCompareOpAccess().getLESS_EQEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:4267:3: (enumLiteral_3= '>=' )
                    {
                    // InternalReflex.g:4267:3: (enumLiteral_3= '>=' )
                    // InternalReflex.g:4268:4: enumLiteral_3= '>='
                    {
                    enumLiteral_3=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareOpAccess().getGREATER_EQEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getCompareOpAccess().getGREATER_EQEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompareOp"


    // $ANTLR start "ruleCompareEqOp"
    // InternalReflex.g:4278:1: ruleCompareEqOp returns [Enumerator current=null] : ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) ) ;
    public final Enumerator ruleCompareEqOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4284:2: ( ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) ) )
            // InternalReflex.g:4285:2: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) )
            {
            // InternalReflex.g:4285:2: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==98) ) {
                alt57=1;
            }
            else if ( (LA57_0==99) ) {
                alt57=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // InternalReflex.g:4286:3: (enumLiteral_0= '==' )
                    {
                    // InternalReflex.g:4286:3: (enumLiteral_0= '==' )
                    // InternalReflex.g:4287:4: enumLiteral_0= '=='
                    {
                    enumLiteral_0=(Token)match(input,98,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareEqOpAccess().getEQEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getCompareEqOpAccess().getEQEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4294:3: (enumLiteral_1= '!=' )
                    {
                    // InternalReflex.g:4294:3: (enumLiteral_1= '!=' )
                    // InternalReflex.g:4295:4: enumLiteral_1= '!='
                    {
                    enumLiteral_1=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareEqOpAccess().getNOT_EQEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getCompareEqOpAccess().getNOT_EQEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompareEqOp"


    // $ANTLR start "ruleShiftOp"
    // InternalReflex.g:4305:1: ruleShiftOp returns [Enumerator current=null] : ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) ) ;
    public final Enumerator ruleShiftOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4311:2: ( ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) ) )
            // InternalReflex.g:4312:2: ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) )
            {
            // InternalReflex.g:4312:2: ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) )
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==100) ) {
                alt58=1;
            }
            else if ( (LA58_0==101) ) {
                alt58=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }
            switch (alt58) {
                case 1 :
                    // InternalReflex.g:4313:3: (enumLiteral_0= '>>' )
                    {
                    // InternalReflex.g:4313:3: (enumLiteral_0= '>>' )
                    // InternalReflex.g:4314:4: enumLiteral_0= '>>'
                    {
                    enumLiteral_0=(Token)match(input,100,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getShiftOpAccess().getLEFT_SHIFTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getShiftOpAccess().getLEFT_SHIFTEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4321:3: (enumLiteral_1= '<<' )
                    {
                    // InternalReflex.g:4321:3: (enumLiteral_1= '<<' )
                    // InternalReflex.g:4322:4: enumLiteral_1= '<<'
                    {
                    enumLiteral_1=(Token)match(input,101,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getShiftOpAccess().getRIGHT_SHIFTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getShiftOpAccess().getRIGHT_SHIFTEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleShiftOp"


    // $ANTLR start "ruleAdditiveOp"
    // InternalReflex.g:4332:1: ruleAdditiveOp returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAdditiveOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4338:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalReflex.g:4339:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalReflex.g:4339:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==90) ) {
                alt59=1;
            }
            else if ( (LA59_0==91) ) {
                alt59=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 59, 0, input);

                throw nvae;
            }
            switch (alt59) {
                case 1 :
                    // InternalReflex.g:4340:3: (enumLiteral_0= '+' )
                    {
                    // InternalReflex.g:4340:3: (enumLiteral_0= '+' )
                    // InternalReflex.g:4341:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAdditiveOpAccess().getPLUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAdditiveOpAccess().getPLUSEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4348:3: (enumLiteral_1= '-' )
                    {
                    // InternalReflex.g:4348:3: (enumLiteral_1= '-' )
                    // InternalReflex.g:4349:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAdditiveOpAccess().getMINUSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getAdditiveOpAccess().getMINUSEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditiveOp"


    // $ANTLR start "ruleMultiplicativeOp"
    // InternalReflex.g:4359:1: ruleMultiplicativeOp returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplicativeOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalReflex.g:4365:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalReflex.g:4366:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalReflex.g:4366:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt60=3;
            switch ( input.LA(1) ) {
            case 102:
                {
                alt60=1;
                }
                break;
            case 103:
                {
                alt60=2;
                }
                break;
            case 104:
                {
                alt60=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }

            switch (alt60) {
                case 1 :
                    // InternalReflex.g:4367:3: (enumLiteral_0= '*' )
                    {
                    // InternalReflex.g:4367:3: (enumLiteral_0= '*' )
                    // InternalReflex.g:4368:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,102,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplicativeOpAccess().getMULEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getMultiplicativeOpAccess().getMULEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4375:3: (enumLiteral_1= '/' )
                    {
                    // InternalReflex.g:4375:3: (enumLiteral_1= '/' )
                    // InternalReflex.g:4376:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,103,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplicativeOpAccess().getDIVEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getMultiplicativeOpAccess().getDIVEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4383:3: (enumLiteral_2= '%' )
                    {
                    // InternalReflex.g:4383:3: (enumLiteral_2= '%' )
                    // InternalReflex.g:4384:4: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,104,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplicativeOpAccess().getMODEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getMultiplicativeOpAccess().getMODEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMultiplicativeOp"


    // $ANTLR start "ruleType"
    // InternalReflex.g:4394:1: ruleType returns [Enumerator current=null] : ( (enumLiteral_0= 'void' ) | (enumLiteral_1= 'float' ) | (enumLiteral_2= 'double' ) | (enumLiteral_3= 'int8' ) | (enumLiteral_4= 'uint8' ) | (enumLiteral_5= 'int16' ) | (enumLiteral_6= 'uint16' ) | (enumLiteral_7= 'int32' ) | (enumLiteral_8= 'uint32' ) | (enumLiteral_9= 'int64' ) | (enumLiteral_10= 'uint64' ) | (enumLiteral_11= 'bool' ) | (enumLiteral_12= 'time' ) ) ;
    public final Enumerator ruleType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;
        Token enumLiteral_7=null;
        Token enumLiteral_8=null;
        Token enumLiteral_9=null;
        Token enumLiteral_10=null;
        Token enumLiteral_11=null;
        Token enumLiteral_12=null;


        	enterRule();

        try {
            // InternalReflex.g:4400:2: ( ( (enumLiteral_0= 'void' ) | (enumLiteral_1= 'float' ) | (enumLiteral_2= 'double' ) | (enumLiteral_3= 'int8' ) | (enumLiteral_4= 'uint8' ) | (enumLiteral_5= 'int16' ) | (enumLiteral_6= 'uint16' ) | (enumLiteral_7= 'int32' ) | (enumLiteral_8= 'uint32' ) | (enumLiteral_9= 'int64' ) | (enumLiteral_10= 'uint64' ) | (enumLiteral_11= 'bool' ) | (enumLiteral_12= 'time' ) ) )
            // InternalReflex.g:4401:2: ( (enumLiteral_0= 'void' ) | (enumLiteral_1= 'float' ) | (enumLiteral_2= 'double' ) | (enumLiteral_3= 'int8' ) | (enumLiteral_4= 'uint8' ) | (enumLiteral_5= 'int16' ) | (enumLiteral_6= 'uint16' ) | (enumLiteral_7= 'int32' ) | (enumLiteral_8= 'uint32' ) | (enumLiteral_9= 'int64' ) | (enumLiteral_10= 'uint64' ) | (enumLiteral_11= 'bool' ) | (enumLiteral_12= 'time' ) )
            {
            // InternalReflex.g:4401:2: ( (enumLiteral_0= 'void' ) | (enumLiteral_1= 'float' ) | (enumLiteral_2= 'double' ) | (enumLiteral_3= 'int8' ) | (enumLiteral_4= 'uint8' ) | (enumLiteral_5= 'int16' ) | (enumLiteral_6= 'uint16' ) | (enumLiteral_7= 'int32' ) | (enumLiteral_8= 'uint32' ) | (enumLiteral_9= 'int64' ) | (enumLiteral_10= 'uint64' ) | (enumLiteral_11= 'bool' ) | (enumLiteral_12= 'time' ) )
            int alt61=13;
            switch ( input.LA(1) ) {
            case 105:
                {
                alt61=1;
                }
                break;
            case 106:
                {
                alt61=2;
                }
                break;
            case 107:
                {
                alt61=3;
                }
                break;
            case 108:
                {
                alt61=4;
                }
                break;
            case 109:
                {
                alt61=5;
                }
                break;
            case 110:
                {
                alt61=6;
                }
                break;
            case 111:
                {
                alt61=7;
                }
                break;
            case 112:
                {
                alt61=8;
                }
                break;
            case 113:
                {
                alt61=9;
                }
                break;
            case 114:
                {
                alt61=10;
                }
                break;
            case 115:
                {
                alt61=11;
                }
                break;
            case 116:
                {
                alt61=12;
                }
                break;
            case 117:
                {
                alt61=13;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }

            switch (alt61) {
                case 1 :
                    // InternalReflex.g:4402:3: (enumLiteral_0= 'void' )
                    {
                    // InternalReflex.g:4402:3: (enumLiteral_0= 'void' )
                    // InternalReflex.g:4403:4: enumLiteral_0= 'void'
                    {
                    enumLiteral_0=(Token)match(input,105,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeAccess().getVOID_C_TYPEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getTypeAccess().getVOID_C_TYPEEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4410:3: (enumLiteral_1= 'float' )
                    {
                    // InternalReflex.g:4410:3: (enumLiteral_1= 'float' )
                    // InternalReflex.g:4411:4: enumLiteral_1= 'float'
                    {
                    enumLiteral_1=(Token)match(input,106,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeAccess().getFLOATEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getTypeAccess().getFLOATEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4418:3: (enumLiteral_2= 'double' )
                    {
                    // InternalReflex.g:4418:3: (enumLiteral_2= 'double' )
                    // InternalReflex.g:4419:4: enumLiteral_2= 'double'
                    {
                    enumLiteral_2=(Token)match(input,107,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeAccess().getDOUBLEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getTypeAccess().getDOUBLEEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:4426:3: (enumLiteral_3= 'int8' )
                    {
                    // InternalReflex.g:4426:3: (enumLiteral_3= 'int8' )
                    // InternalReflex.g:4427:4: enumLiteral_3= 'int8'
                    {
                    enumLiteral_3=(Token)match(input,108,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeAccess().getINT8EnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getTypeAccess().getINT8EnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalReflex.g:4434:3: (enumLiteral_4= 'uint8' )
                    {
                    // InternalReflex.g:4434:3: (enumLiteral_4= 'uint8' )
                    // InternalReflex.g:4435:4: enumLiteral_4= 'uint8'
                    {
                    enumLiteral_4=(Token)match(input,109,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeAccess().getINT8_UEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getTypeAccess().getINT8_UEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalReflex.g:4442:3: (enumLiteral_5= 'int16' )
                    {
                    // InternalReflex.g:4442:3: (enumLiteral_5= 'int16' )
                    // InternalReflex.g:4443:4: enumLiteral_5= 'int16'
                    {
                    enumLiteral_5=(Token)match(input,110,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeAccess().getINT16EnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getTypeAccess().getINT16EnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalReflex.g:4450:3: (enumLiteral_6= 'uint16' )
                    {
                    // InternalReflex.g:4450:3: (enumLiteral_6= 'uint16' )
                    // InternalReflex.g:4451:4: enumLiteral_6= 'uint16'
                    {
                    enumLiteral_6=(Token)match(input,111,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeAccess().getINT16_UEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getTypeAccess().getINT16_UEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalReflex.g:4458:3: (enumLiteral_7= 'int32' )
                    {
                    // InternalReflex.g:4458:3: (enumLiteral_7= 'int32' )
                    // InternalReflex.g:4459:4: enumLiteral_7= 'int32'
                    {
                    enumLiteral_7=(Token)match(input,112,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeAccess().getINT32EnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getTypeAccess().getINT32EnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalReflex.g:4466:3: (enumLiteral_8= 'uint32' )
                    {
                    // InternalReflex.g:4466:3: (enumLiteral_8= 'uint32' )
                    // InternalReflex.g:4467:4: enumLiteral_8= 'uint32'
                    {
                    enumLiteral_8=(Token)match(input,113,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeAccess().getINT32_UEnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getTypeAccess().getINT32_UEnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalReflex.g:4474:3: (enumLiteral_9= 'int64' )
                    {
                    // InternalReflex.g:4474:3: (enumLiteral_9= 'int64' )
                    // InternalReflex.g:4475:4: enumLiteral_9= 'int64'
                    {
                    enumLiteral_9=(Token)match(input,114,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeAccess().getINT64EnumLiteralDeclaration_9().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_9, grammarAccess.getTypeAccess().getINT64EnumLiteralDeclaration_9());
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalReflex.g:4482:3: (enumLiteral_10= 'uint64' )
                    {
                    // InternalReflex.g:4482:3: (enumLiteral_10= 'uint64' )
                    // InternalReflex.g:4483:4: enumLiteral_10= 'uint64'
                    {
                    enumLiteral_10=(Token)match(input,115,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeAccess().getINT64_UEnumLiteralDeclaration_10().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_10, grammarAccess.getTypeAccess().getINT64_UEnumLiteralDeclaration_10());
                      			
                    }

                    }


                    }
                    break;
                case 12 :
                    // InternalReflex.g:4490:3: (enumLiteral_11= 'bool' )
                    {
                    // InternalReflex.g:4490:3: (enumLiteral_11= 'bool' )
                    // InternalReflex.g:4491:4: enumLiteral_11= 'bool'
                    {
                    enumLiteral_11=(Token)match(input,116,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeAccess().getBOOLEnumLiteralDeclaration_11().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_11, grammarAccess.getTypeAccess().getBOOLEnumLiteralDeclaration_11());
                      			
                    }

                    }


                    }
                    break;
                case 13 :
                    // InternalReflex.g:4498:3: (enumLiteral_12= 'time' )
                    {
                    // InternalReflex.g:4498:3: (enumLiteral_12= 'time' )
                    // InternalReflex.g:4499:4: enumLiteral_12= 'time'
                    {
                    enumLiteral_12=(Token)match(input,117,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeAccess().getTIMEEnumLiteralDeclaration_12().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_12, grammarAccess.getTypeAccess().getTIMEEnumLiteralDeclaration_12());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleType"

    // $ANTLR start synpred1_InternalReflex
    public final void synpred1_InternalReflex_fragment() throws RecognitionException {   
        // InternalReflex.g:2020:5: ( 'else' )
        // InternalReflex.g:2020:6: 'else'
        {
        match(input,61,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_InternalReflex

    // Delegated rules

    public final boolean synpred1_InternalReflex() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalReflex_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA14 dfa14 = new DFA14(this);
    protected DFA16 dfa16 = new DFA16(this);
    static final String dfa_1s = "\26\uffff";
    static final String dfa_2s = "\1\47\3\uffff\15\4\2\uffff\1\55\2\uffff";
    static final String dfa_3s = "\1\165\3\uffff\15\4\2\uffff\1\70\2\uffff";
    static final String dfa_4s = "\1\uffff\1\7\1\1\1\2\15\uffff\1\5\1\6\1\uffff\1\4\1\3";
    static final String dfa_5s = "\26\uffff}>";
    static final String[] dfa_6s = {
            "\1\22\3\uffff\1\1\2\uffff\1\22\13\uffff\1\2\1\3\17\uffff\2\21\34\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20",
            "",
            "",
            "",
            "\1\23",
            "\1\23",
            "\1\23",
            "\1\23",
            "\1\23",
            "\1\23",
            "\1\23",
            "\1\23",
            "\1\23",
            "\1\23",
            "\1\23",
            "\1\23",
            "\1\23",
            "",
            "",
            "\1\24\10\uffff\1\24\1\uffff\1\25",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 154:3: ( ( (lv_consts_7_0= ruleConst ) ) | ( (lv_enums_8_0= ruleEnum ) ) | ( (lv_functions_9_0= ruleFunction ) ) | ( (lv_globalVars_10_0= ruleGlobalVariable ) ) | ( (lv_ports_11_0= rulePort ) ) | ( (lv_processes_12_0= ruleProcess ) ) )*";
        }
    }
    static final String dfa_7s = "\21\uffff";
    static final String dfa_8s = "\16\uffff\1\20\2\uffff";
    static final String dfa_9s = "\1\151\15\4\1\55\2\uffff";
    static final String dfa_10s = "\1\165\15\4\1\66\2\uffff";
    static final String dfa_11s = "\17\uffff\1\1\1\2";
    static final String dfa_12s = "\21\uffff}>";
    static final String[] dfa_13s = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\20\5\uffff\1\20\2\uffff\1\17",
            "",
            ""
    };

    static final short[] dfa_7 = DFA.unpackEncodedString(dfa_7s);
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "846:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable )";
        }
    }
    static final String dfa_14s = "\17\uffff\1\2\1\1";
    static final String[] dfa_15s = {
            "\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\16",
            "\1\17\10\uffff\1\20",
            "",
            ""
    };
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final short[][] dfa_15 = unpackEncodedStringArray(dfa_15s);

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_14;
            this.special = dfa_12;
            this.transition = dfa_15;
        }
        public String getDescription() {
            return "898:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000028000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0C00488000000000L,0x003FFE0000001800L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000060L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000408000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0008888000000000L,0x003FFE0000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000888000000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000808000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0001040000000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x51806C0000000370L,0x000000003C01817CL});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0080080000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0030000000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0008000000000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000010000000020L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0100000000000070L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x5100640000000370L,0x000000003C01817CL});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000070L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x003FFE0000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0210000000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0010080000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0040000000000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x5100640000000372L,0x000000003C01817CL});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x51006C0000000370L,0x000000003C01817CL});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x8000080000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x51006C0000000370L,0x000000003C01817EL});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x5100640000000372L,0x000000003C01817EL});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000600000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000800000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000000L,0x0000000000018000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x5300640000000370L,0x000000003C01817CL});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000000L,0x0000000000006018L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000002L,0x000001C000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000002L,0x000000000C000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000002L,0x0000003000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000002L,0x00000003C0000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000002L,0x0000000C00000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0040000000000000L,0x0000000003FE0000L});

}