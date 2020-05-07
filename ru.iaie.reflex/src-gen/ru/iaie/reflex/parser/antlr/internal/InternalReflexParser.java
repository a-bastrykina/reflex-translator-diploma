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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INTEGER", "RULE_FLOAT", "RULE_BIT_AND", "RULE_BIT_XOR", "RULE_BIT_OR", "RULE_LOGICAL_AND", "RULE_LOGICAL_OR", "RULE_STRING", "RULE_HEX", "RULE_OCTAL", "RULE_DECIMAL", "RULE_LONG", "RULE_UNSIGNED", "RULE_DEC_FLOAT", "RULE_HEX_FLOAT", "RULE_DEC_SEQUENCE", "RULE_EXPONENT", "RULE_SIGN", "RULE_FLOAT_SUFFIX", "RULE_HEX_SEQUENCE", "RULE_BIN_EXPONENT", "RULE_HEX_PREFIX", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'['", "']'", "'program'", "'{'", "'}'", "'clock'", "';'", "'process'", "'state'", "'looped'", "'shared'", "','", "'from'", "'='", "'timeout'", "'('", "')'", "'if'", "'else'", "'switch'", "'case'", "':'", "'break'", "'start'", "'stop'", "'error'", "'restart'", "'reset'", "'timer'", "'set'", "'next'", "'const'", "'enum'", "'in'", "'.'", "'input'", "'output'", "'active'", "'inactive'", "'++'", "'--'", "'*='", "'/='", "'+='", "'-='", "'<<='", "'>>='", "'&='", "'^='", "'|='", "'+'", "'-'", "'~'", "'!'", "'<'", "'>'", "'=<'", "'>='", "'=='", "'!='", "'>>'", "'<<'", "'*'", "'/'", "'%'", "'true'", "'false'", "'void'", "'float'", "'double'", "'short'", "'int'", "'long'", "'bool'", "'signed'", "'unsigned'"
    };
    public static final int RULE_HEX=13;
    public static final int T__50=50;
    public static final int RULE_SIGN=22;
    public static final int RULE_DEC_SEQUENCE=20;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_HEX_FLOAT=19;
    public static final int RULE_INT=27;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=28;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__32=32;
    public static final int RULE_HEX_SEQUENCE=24;
    public static final int RULE_UNSIGNED=17;
    public static final int RULE_BIN_EXPONENT=25;
    public static final int RULE_LOGICAL_AND=10;
    public static final int RULE_EXPONENT=21;
    public static final int T__48=48;
    public static final int RULE_DEC_FLOAT=18;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_FLOAT=6;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int RULE_BIT_AND=7;
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
    public static final int T__90=90;
    public static final int RULE_OCTAL=14;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int RULE_DECIMAL=15;
    public static final int RULE_LOGICAL_OR=11;
    public static final int RULE_FLOAT_SUFFIX=23;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=12;
    public static final int RULE_SL_COMMENT=29;
    public static final int RULE_HEX_PREFIX=26;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__75=75;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=30;
    public static final int RULE_ANY_OTHER=31;
    public static final int T__88=88;
    public static final int RULE_BIT_XOR=8;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int RULE_BIT_OR=9;
    public static final int RULE_LONG=16;
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
    // InternalReflex.g:72:1: ruleProgram returns [EObject current=null] : ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'program' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( (lv_ticks_6_0= ruleTact ) )? ( ( (lv_consts_7_0= ruleConst ) ) | ( (lv_enums_8_0= ruleEnum ) ) | ( (lv_functions_9_0= ruleFunction ) ) | ( (lv_globalVars_10_0= ruleGlobalVariable ) ) | ( (lv_registers_11_0= ruleRegister ) ) | ( (lv_processes_12_0= ruleProcess ) ) )* otherlv_13= '}' ) ;
    public final EObject ruleProgram() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        Token otherlv_13=null;
        EObject lv_annotations_1_0 = null;

        EObject lv_ticks_6_0 = null;

        EObject lv_consts_7_0 = null;

        EObject lv_enums_8_0 = null;

        EObject lv_functions_9_0 = null;

        EObject lv_globalVars_10_0 = null;

        EObject lv_registers_11_0 = null;

        EObject lv_processes_12_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:78:2: ( ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'program' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( (lv_ticks_6_0= ruleTact ) )? ( ( (lv_consts_7_0= ruleConst ) ) | ( (lv_enums_8_0= ruleEnum ) ) | ( (lv_functions_9_0= ruleFunction ) ) | ( (lv_globalVars_10_0= ruleGlobalVariable ) ) | ( (lv_registers_11_0= ruleRegister ) ) | ( (lv_processes_12_0= ruleProcess ) ) )* otherlv_13= '}' ) )
            // InternalReflex.g:79:2: ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'program' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( (lv_ticks_6_0= ruleTact ) )? ( ( (lv_consts_7_0= ruleConst ) ) | ( (lv_enums_8_0= ruleEnum ) ) | ( (lv_functions_9_0= ruleFunction ) ) | ( (lv_globalVars_10_0= ruleGlobalVariable ) ) | ( (lv_registers_11_0= ruleRegister ) ) | ( (lv_processes_12_0= ruleProcess ) ) )* otherlv_13= '}' )
            {
            // InternalReflex.g:79:2: ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'program' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( (lv_ticks_6_0= ruleTact ) )? ( ( (lv_consts_7_0= ruleConst ) ) | ( (lv_enums_8_0= ruleEnum ) ) | ( (lv_functions_9_0= ruleFunction ) ) | ( (lv_globalVars_10_0= ruleGlobalVariable ) ) | ( (lv_registers_11_0= ruleRegister ) ) | ( (lv_processes_12_0= ruleProcess ) ) )* otherlv_13= '}' )
            // InternalReflex.g:80:3: (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'program' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( (lv_ticks_6_0= ruleTact ) )? ( ( (lv_consts_7_0= ruleConst ) ) | ( (lv_enums_8_0= ruleEnum ) ) | ( (lv_functions_9_0= ruleFunction ) ) | ( (lv_globalVars_10_0= ruleGlobalVariable ) ) | ( (lv_registers_11_0= ruleRegister ) ) | ( (lv_processes_12_0= ruleProcess ) ) )* otherlv_13= '}'
            {
            // InternalReflex.g:80:3: (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==32) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalReflex.g:81:4: otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']'
            	    {
            	    otherlv_0=(Token)match(input,32,FOLLOW_3); if (state.failed) return current;
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

            	    otherlv_2=(Token)match(input,33,FOLLOW_5); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getProgramAccess().getRightSquareBracketKeyword_0_2());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_3=(Token)match(input,34,FOLLOW_3); if (state.failed) return current;
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

            otherlv_5=(Token)match(input,35,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getProgramAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalReflex.g:135:3: ( (lv_ticks_6_0= ruleTact ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==37) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalReflex.g:136:4: (lv_ticks_6_0= ruleTact )
                    {
                    // InternalReflex.g:136:4: (lv_ticks_6_0= ruleTact )
                    // InternalReflex.g:137:5: lv_ticks_6_0= ruleTact
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getProgramAccess().getTicksTactParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_8);
                    lv_ticks_6_0=ruleTact();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getProgramRule());
                      					}
                      					set(
                      						current,
                      						"ticks",
                      						lv_ticks_6_0,
                      						"ru.iaie.reflex.Reflex.Tact");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalReflex.g:154:3: ( ( (lv_consts_7_0= ruleConst ) ) | ( (lv_enums_8_0= ruleEnum ) ) | ( (lv_functions_9_0= ruleFunction ) ) | ( (lv_globalVars_10_0= ruleGlobalVariable ) ) | ( (lv_registers_11_0= ruleRegister ) ) | ( (lv_processes_12_0= ruleProcess ) ) )*
            loop3:
            do {
                int alt3=7;
                alt3 = dfa3.predict(input);
                switch (alt3) {
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
            	    // InternalReflex.g:235:4: ( (lv_registers_11_0= ruleRegister ) )
            	    {
            	    // InternalReflex.g:235:4: ( (lv_registers_11_0= ruleRegister ) )
            	    // InternalReflex.g:236:5: (lv_registers_11_0= ruleRegister )
            	    {
            	    // InternalReflex.g:236:5: (lv_registers_11_0= ruleRegister )
            	    // InternalReflex.g:237:6: lv_registers_11_0= ruleRegister
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getProgramAccess().getRegistersRegisterParserRuleCall_5_4_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_8);
            	    lv_registers_11_0=ruleRegister();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getProgramRule());
            	      						}
            	      						add(
            	      							current,
            	      							"registers",
            	      							lv_registers_11_0,
            	      							"ru.iaie.reflex.Reflex.Register");
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
            	    break loop3;
                }
            } while (true);

            otherlv_13=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleTact"
    // InternalReflex.g:283:1: entryRuleTact returns [EObject current=null] : iv_ruleTact= ruleTact EOF ;
    public final EObject entryRuleTact() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTact = null;


        try {
            // InternalReflex.g:283:45: (iv_ruleTact= ruleTact EOF )
            // InternalReflex.g:284:2: iv_ruleTact= ruleTact EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTactRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTact=ruleTact();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTact; 
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
    // $ANTLR end "entryRuleTact"


    // $ANTLR start "ruleTact"
    // InternalReflex.g:290:1: ruleTact returns [EObject current=null] : (otherlv_0= 'clock' ( (lv_value_1_0= RULE_INTEGER ) ) otherlv_2= ';' ) ;
    public final EObject ruleTact() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalReflex.g:296:2: ( (otherlv_0= 'clock' ( (lv_value_1_0= RULE_INTEGER ) ) otherlv_2= ';' ) )
            // InternalReflex.g:297:2: (otherlv_0= 'clock' ( (lv_value_1_0= RULE_INTEGER ) ) otherlv_2= ';' )
            {
            // InternalReflex.g:297:2: (otherlv_0= 'clock' ( (lv_value_1_0= RULE_INTEGER ) ) otherlv_2= ';' )
            // InternalReflex.g:298:3: otherlv_0= 'clock' ( (lv_value_1_0= RULE_INTEGER ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,37,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTactAccess().getClockKeyword_0());
              		
            }
            // InternalReflex.g:302:3: ( (lv_value_1_0= RULE_INTEGER ) )
            // InternalReflex.g:303:4: (lv_value_1_0= RULE_INTEGER )
            {
            // InternalReflex.g:303:4: (lv_value_1_0= RULE_INTEGER )
            // InternalReflex.g:304:5: lv_value_1_0= RULE_INTEGER
            {
            lv_value_1_0=(Token)match(input,RULE_INTEGER,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_value_1_0, grammarAccess.getTactAccess().getValueINTEGERTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getTactRule());
              					}
              					setWithLastConsumed(
              						current,
              						"value",
              						lv_value_1_0,
              						"ru.iaie.reflex.Reflex.INTEGER");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getTactAccess().getSemicolonKeyword_2());
              		
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
    // $ANTLR end "ruleTact"


    // $ANTLR start "entryRuleProcess"
    // InternalReflex.g:328:1: entryRuleProcess returns [EObject current=null] : iv_ruleProcess= ruleProcess EOF ;
    public final EObject entryRuleProcess() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcess = null;


        try {
            // InternalReflex.g:328:48: (iv_ruleProcess= ruleProcess EOF )
            // InternalReflex.g:329:2: iv_ruleProcess= ruleProcess EOF
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
    // InternalReflex.g:335:1: ruleProcess returns [EObject current=null] : ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'process' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( (lv_variables_6_0= ruleProcessVariable ) )* ( (lv_states_7_0= ruleState ) )* otherlv_8= '}' ) ;
    public final EObject ruleProcess() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        EObject lv_annotations_1_0 = null;

        EObject lv_variables_6_0 = null;

        EObject lv_states_7_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:341:2: ( ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'process' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( (lv_variables_6_0= ruleProcessVariable ) )* ( (lv_states_7_0= ruleState ) )* otherlv_8= '}' ) )
            // InternalReflex.g:342:2: ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'process' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( (lv_variables_6_0= ruleProcessVariable ) )* ( (lv_states_7_0= ruleState ) )* otherlv_8= '}' )
            {
            // InternalReflex.g:342:2: ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'process' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( (lv_variables_6_0= ruleProcessVariable ) )* ( (lv_states_7_0= ruleState ) )* otherlv_8= '}' )
            // InternalReflex.g:343:3: (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'process' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '{' ( (lv_variables_6_0= ruleProcessVariable ) )* ( (lv_states_7_0= ruleState ) )* otherlv_8= '}'
            {
            // InternalReflex.g:343:3: (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==32) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalReflex.g:344:4: otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']'
            	    {
            	    otherlv_0=(Token)match(input,32,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_0, grammarAccess.getProcessAccess().getLeftSquareBracketKeyword_0_0());
            	      			
            	    }
            	    // InternalReflex.g:348:4: ( (lv_annotations_1_0= ruleAnnotation ) )
            	    // InternalReflex.g:349:5: (lv_annotations_1_0= ruleAnnotation )
            	    {
            	    // InternalReflex.g:349:5: (lv_annotations_1_0= ruleAnnotation )
            	    // InternalReflex.g:350:6: lv_annotations_1_0= ruleAnnotation
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

            	    otherlv_2=(Token)match(input,33,FOLLOW_11); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getProcessAccess().getRightSquareBracketKeyword_0_2());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            otherlv_3=(Token)match(input,39,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getProcessAccess().getProcessKeyword_1());
              		
            }
            // InternalReflex.g:376:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalReflex.g:377:4: (lv_name_4_0= RULE_ID )
            {
            // InternalReflex.g:377:4: (lv_name_4_0= RULE_ID )
            // InternalReflex.g:378:5: lv_name_4_0= RULE_ID
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

            otherlv_5=(Token)match(input,35,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getProcessAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalReflex.g:398:3: ( (lv_variables_6_0= ruleProcessVariable ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==42||(LA5_0>=99 && LA5_0<=107)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalReflex.g:399:4: (lv_variables_6_0= ruleProcessVariable )
            	    {
            	    // InternalReflex.g:399:4: (lv_variables_6_0= ruleProcessVariable )
            	    // InternalReflex.g:400:5: lv_variables_6_0= ruleProcessVariable
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getProcessAccess().getVariablesProcessVariableParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_12);
            	    lv_variables_6_0=ruleProcessVariable();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getProcessRule());
            	      					}
            	      					add(
            	      						current,
            	      						"variables",
            	      						lv_variables_6_0,
            	      						"ru.iaie.reflex.Reflex.ProcessVariable");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            // InternalReflex.g:417:3: ( (lv_states_7_0= ruleState ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==32||LA6_0==40) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // InternalReflex.g:418:4: (lv_states_7_0= ruleState )
            	    {
            	    // InternalReflex.g:418:4: (lv_states_7_0= ruleState )
            	    // InternalReflex.g:419:5: lv_states_7_0= ruleState
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getProcessAccess().getStatesStateParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_13);
            	    lv_states_7_0=ruleState();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getProcessRule());
            	      					}
            	      					add(
            	      						current,
            	      						"states",
            	      						lv_states_7_0,
            	      						"ru.iaie.reflex.Reflex.State");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            otherlv_8=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getProcessAccess().getRightCurlyBracketKeyword_6());
              		
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
    // InternalReflex.g:444:1: entryRuleState returns [EObject current=null] : iv_ruleState= ruleState EOF ;
    public final EObject entryRuleState() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleState = null;


        try {
            // InternalReflex.g:444:46: (iv_ruleState= ruleState EOF )
            // InternalReflex.g:445:2: iv_ruleState= ruleState EOF
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
    // InternalReflex.g:451:1: ruleState returns [EObject current=null] : ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'state' ( (lv_name_4_0= RULE_ID ) ) ( (lv_looped_5_0= 'looped' ) )? otherlv_6= '{' ( (lv_stateFunction_7_0= ruleStatementSequence ) ) ( (lv_timeoutFunction_8_0= ruleTimeoutFunction ) )? otherlv_9= '}' ) ;
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
            // InternalReflex.g:457:2: ( ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'state' ( (lv_name_4_0= RULE_ID ) ) ( (lv_looped_5_0= 'looped' ) )? otherlv_6= '{' ( (lv_stateFunction_7_0= ruleStatementSequence ) ) ( (lv_timeoutFunction_8_0= ruleTimeoutFunction ) )? otherlv_9= '}' ) )
            // InternalReflex.g:458:2: ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'state' ( (lv_name_4_0= RULE_ID ) ) ( (lv_looped_5_0= 'looped' ) )? otherlv_6= '{' ( (lv_stateFunction_7_0= ruleStatementSequence ) ) ( (lv_timeoutFunction_8_0= ruleTimeoutFunction ) )? otherlv_9= '}' )
            {
            // InternalReflex.g:458:2: ( (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'state' ( (lv_name_4_0= RULE_ID ) ) ( (lv_looped_5_0= 'looped' ) )? otherlv_6= '{' ( (lv_stateFunction_7_0= ruleStatementSequence ) ) ( (lv_timeoutFunction_8_0= ruleTimeoutFunction ) )? otherlv_9= '}' )
            // InternalReflex.g:459:3: (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )* otherlv_3= 'state' ( (lv_name_4_0= RULE_ID ) ) ( (lv_looped_5_0= 'looped' ) )? otherlv_6= '{' ( (lv_stateFunction_7_0= ruleStatementSequence ) ) ( (lv_timeoutFunction_8_0= ruleTimeoutFunction ) )? otherlv_9= '}'
            {
            // InternalReflex.g:459:3: (otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']' )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==32) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalReflex.g:460:4: otherlv_0= '[' ( (lv_annotations_1_0= ruleAnnotation ) ) otherlv_2= ']'
            	    {
            	    otherlv_0=(Token)match(input,32,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_0, grammarAccess.getStateAccess().getLeftSquareBracketKeyword_0_0());
            	      			
            	    }
            	    // InternalReflex.g:464:4: ( (lv_annotations_1_0= ruleAnnotation ) )
            	    // InternalReflex.g:465:5: (lv_annotations_1_0= ruleAnnotation )
            	    {
            	    // InternalReflex.g:465:5: (lv_annotations_1_0= ruleAnnotation )
            	    // InternalReflex.g:466:6: lv_annotations_1_0= ruleAnnotation
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

            	    otherlv_2=(Token)match(input,33,FOLLOW_14); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getStateAccess().getRightSquareBracketKeyword_0_2());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            otherlv_3=(Token)match(input,40,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getStateAccess().getStateKeyword_1());
              		
            }
            // InternalReflex.g:492:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalReflex.g:493:4: (lv_name_4_0= RULE_ID )
            {
            // InternalReflex.g:493:4: (lv_name_4_0= RULE_ID )
            // InternalReflex.g:494:5: lv_name_4_0= RULE_ID
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

            // InternalReflex.g:510:3: ( (lv_looped_5_0= 'looped' ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==41) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalReflex.g:511:4: (lv_looped_5_0= 'looped' )
                    {
                    // InternalReflex.g:511:4: (lv_looped_5_0= 'looped' )
                    // InternalReflex.g:512:5: lv_looped_5_0= 'looped'
                    {
                    lv_looped_5_0=(Token)match(input,41,FOLLOW_6); if (state.failed) return current;
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

            otherlv_6=(Token)match(input,35,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getStateAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalReflex.g:528:3: ( (lv_stateFunction_7_0= ruleStatementSequence ) )
            // InternalReflex.g:529:4: (lv_stateFunction_7_0= ruleStatementSequence )
            {
            // InternalReflex.g:529:4: (lv_stateFunction_7_0= ruleStatementSequence )
            // InternalReflex.g:530:5: lv_stateFunction_7_0= ruleStatementSequence
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

            // InternalReflex.g:547:3: ( (lv_timeoutFunction_8_0= ruleTimeoutFunction ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==46) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalReflex.g:548:4: (lv_timeoutFunction_8_0= ruleTimeoutFunction )
                    {
                    // InternalReflex.g:548:4: (lv_timeoutFunction_8_0= ruleTimeoutFunction )
                    // InternalReflex.g:549:5: lv_timeoutFunction_8_0= ruleTimeoutFunction
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

            otherlv_9=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleProcessVariable"
    // InternalReflex.g:574:1: entryRuleProcessVariable returns [EObject current=null] : iv_ruleProcessVariable= ruleProcessVariable EOF ;
    public final EObject entryRuleProcessVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProcessVariable = null;


        try {
            // InternalReflex.g:574:56: (iv_ruleProcessVariable= ruleProcessVariable EOF )
            // InternalReflex.g:575:2: iv_ruleProcessVariable= ruleProcessVariable EOF
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
    // InternalReflex.g:581:1: ruleProcessVariable returns [EObject current=null] : ( (this_ImportedVariableList_0= ruleImportedVariableList | this_DeclaredVariable_1= ruleDeclaredVariable ) otherlv_2= ';' ) ;
    public final EObject ruleProcessVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_ImportedVariableList_0 = null;

        EObject this_DeclaredVariable_1 = null;



        	enterRule();

        try {
            // InternalReflex.g:587:2: ( ( (this_ImportedVariableList_0= ruleImportedVariableList | this_DeclaredVariable_1= ruleDeclaredVariable ) otherlv_2= ';' ) )
            // InternalReflex.g:588:2: ( (this_ImportedVariableList_0= ruleImportedVariableList | this_DeclaredVariable_1= ruleDeclaredVariable ) otherlv_2= ';' )
            {
            // InternalReflex.g:588:2: ( (this_ImportedVariableList_0= ruleImportedVariableList | this_DeclaredVariable_1= ruleDeclaredVariable ) otherlv_2= ';' )
            // InternalReflex.g:589:3: (this_ImportedVariableList_0= ruleImportedVariableList | this_DeclaredVariable_1= ruleDeclaredVariable ) otherlv_2= ';'
            {
            // InternalReflex.g:589:3: (this_ImportedVariableList_0= ruleImportedVariableList | this_DeclaredVariable_1= ruleDeclaredVariable )
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==42) ) {
                alt10=1;
            }
            else if ( ((LA10_0>=99 && LA10_0<=107)) ) {
                alt10=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }
            switch (alt10) {
                case 1 :
                    // InternalReflex.g:590:4: this_ImportedVariableList_0= ruleImportedVariableList
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getProcessVariableAccess().getImportedVariableListParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_10);
                    this_ImportedVariableList_0=ruleImportedVariableList();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_ImportedVariableList_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalReflex.g:599:4: this_DeclaredVariable_1= ruleDeclaredVariable
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getProcessVariableAccess().getDeclaredVariableParserRuleCall_0_1());
                      			
                    }
                    pushFollow(FOLLOW_10);
                    this_DeclaredVariable_1=ruleDeclaredVariable();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_DeclaredVariable_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            otherlv_2=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getProcessVariableAccess().getSemicolonKeyword_1());
              		
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


    // $ANTLR start "entryRuleImportedVariableList"
    // InternalReflex.g:616:1: entryRuleImportedVariableList returns [EObject current=null] : iv_ruleImportedVariableList= ruleImportedVariableList EOF ;
    public final EObject entryRuleImportedVariableList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImportedVariableList = null;


        try {
            // InternalReflex.g:616:61: (iv_ruleImportedVariableList= ruleImportedVariableList EOF )
            // InternalReflex.g:617:2: iv_ruleImportedVariableList= ruleImportedVariableList EOF
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
    // InternalReflex.g:623:1: ruleImportedVariableList returns [EObject current=null] : (otherlv_0= 'shared' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) otherlv_4= 'from' otherlv_5= 'process' ( (otherlv_6= RULE_ID ) ) ) ;
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
            // InternalReflex.g:629:2: ( (otherlv_0= 'shared' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) otherlv_4= 'from' otherlv_5= 'process' ( (otherlv_6= RULE_ID ) ) ) )
            // InternalReflex.g:630:2: (otherlv_0= 'shared' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) otherlv_4= 'from' otherlv_5= 'process' ( (otherlv_6= RULE_ID ) ) )
            {
            // InternalReflex.g:630:2: (otherlv_0= 'shared' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) otherlv_4= 'from' otherlv_5= 'process' ( (otherlv_6= RULE_ID ) ) )
            // InternalReflex.g:631:3: otherlv_0= 'shared' ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* ) otherlv_4= 'from' otherlv_5= 'process' ( (otherlv_6= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,42,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImportedVariableListAccess().getSharedKeyword_0());
              		
            }
            // InternalReflex.g:635:3: ( ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )* )
            // InternalReflex.g:636:4: ( (otherlv_1= RULE_ID ) ) (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
            {
            // InternalReflex.g:636:4: ( (otherlv_1= RULE_ID ) )
            // InternalReflex.g:637:5: (otherlv_1= RULE_ID )
            {
            // InternalReflex.g:637:5: (otherlv_1= RULE_ID )
            // InternalReflex.g:638:6: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              						if (current==null) {
              							current = createModelElement(grammarAccess.getImportedVariableListRule());
              						}
              					
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              						newLeafNode(otherlv_1, grammarAccess.getImportedVariableListAccess().getVariablesDeclaredVariableCrossReference_1_0_0());
              					
            }

            }


            }

            // InternalReflex.g:649:4: (otherlv_2= ',' ( (otherlv_3= RULE_ID ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==43) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalReflex.g:650:5: otherlv_2= ',' ( (otherlv_3= RULE_ID ) )
            	    {
            	    otherlv_2=(Token)match(input,43,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_2, grammarAccess.getImportedVariableListAccess().getCommaKeyword_1_1_0());
            	      				
            	    }
            	    // InternalReflex.g:654:5: ( (otherlv_3= RULE_ID ) )
            	    // InternalReflex.g:655:6: (otherlv_3= RULE_ID )
            	    {
            	    // InternalReflex.g:655:6: (otherlv_3= RULE_ID )
            	    // InternalReflex.g:656:7: otherlv_3= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {

            	      							if (current==null) {
            	      								current = createModelElement(grammarAccess.getImportedVariableListRule());
            	      							}
            	      						
            	    }
            	    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_19); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      							newLeafNode(otherlv_3, grammarAccess.getImportedVariableListAccess().getVariablesDeclaredVariableCrossReference_1_1_1_0());
            	      						
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);


            }

            otherlv_4=(Token)match(input,44,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getImportedVariableListAccess().getFromKeyword_2());
              		
            }
            otherlv_5=(Token)match(input,39,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getImportedVariableListAccess().getProcessKeyword_3());
              		
            }
            // InternalReflex.g:677:3: ( (otherlv_6= RULE_ID ) )
            // InternalReflex.g:678:4: (otherlv_6= RULE_ID )
            {
            // InternalReflex.g:678:4: (otherlv_6= RULE_ID )
            // InternalReflex.g:679:5: otherlv_6= RULE_ID
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


    // $ANTLR start "entryRuleDeclaredVariable"
    // InternalReflex.g:694:1: entryRuleDeclaredVariable returns [EObject current=null] : iv_ruleDeclaredVariable= ruleDeclaredVariable EOF ;
    public final EObject entryRuleDeclaredVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaredVariable = null;


        try {
            // InternalReflex.g:694:57: (iv_ruleDeclaredVariable= ruleDeclaredVariable EOF )
            // InternalReflex.g:695:2: iv_ruleDeclaredVariable= ruleDeclaredVariable EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclaredVariableRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDeclaredVariable=ruleDeclaredVariable();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclaredVariable; 
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
    // $ANTLR end "entryRuleDeclaredVariable"


    // $ANTLR start "ruleDeclaredVariable"
    // InternalReflex.g:701:1: ruleDeclaredVariable returns [EObject current=null] : ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_shared_2_0= 'shared' ) )? ) ;
    public final EObject ruleDeclaredVariable() throws RecognitionException {
        EObject current = null;

        Token lv_shared_2_0=null;
        EObject this_PhysicalVariable_0 = null;

        EObject this_ProgramVariable_1 = null;



        	enterRule();

        try {
            // InternalReflex.g:707:2: ( ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_shared_2_0= 'shared' ) )? ) )
            // InternalReflex.g:708:2: ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_shared_2_0= 'shared' ) )? )
            {
            // InternalReflex.g:708:2: ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_shared_2_0= 'shared' ) )? )
            // InternalReflex.g:709:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) ( (lv_shared_2_0= 'shared' ) )?
            {
            // InternalReflex.g:709:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable )
            int alt12=2;
            alt12 = dfa12.predict(input);
            switch (alt12) {
                case 1 :
                    // InternalReflex.g:710:4: this_PhysicalVariable_0= rulePhysicalVariable
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getDeclaredVariableAccess().getPhysicalVariableParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_21);
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
                    // InternalReflex.g:719:4: this_ProgramVariable_1= ruleProgramVariable
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getDeclaredVariableAccess().getProgramVariableParserRuleCall_0_1());
                      			
                    }
                    pushFollow(FOLLOW_21);
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

            // InternalReflex.g:728:3: ( (lv_shared_2_0= 'shared' ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==42) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalReflex.g:729:4: (lv_shared_2_0= 'shared' )
                    {
                    // InternalReflex.g:729:4: (lv_shared_2_0= 'shared' )
                    // InternalReflex.g:730:5: lv_shared_2_0= 'shared'
                    {
                    lv_shared_2_0=(Token)match(input,42,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_shared_2_0, grammarAccess.getDeclaredVariableAccess().getSharedSharedKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getDeclaredVariableRule());
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
    // $ANTLR end "ruleDeclaredVariable"


    // $ANTLR start "entryRuleGlobalVariable"
    // InternalReflex.g:746:1: entryRuleGlobalVariable returns [EObject current=null] : iv_ruleGlobalVariable= ruleGlobalVariable EOF ;
    public final EObject entryRuleGlobalVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGlobalVariable = null;


        try {
            // InternalReflex.g:746:55: (iv_ruleGlobalVariable= ruleGlobalVariable EOF )
            // InternalReflex.g:747:2: iv_ruleGlobalVariable= ruleGlobalVariable EOF
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
    // InternalReflex.g:753:1: ruleGlobalVariable returns [EObject current=null] : ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) otherlv_2= ';' ) ;
    public final EObject ruleGlobalVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_PhysicalVariable_0 = null;

        EObject this_ProgramVariable_1 = null;



        	enterRule();

        try {
            // InternalReflex.g:759:2: ( ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) otherlv_2= ';' ) )
            // InternalReflex.g:760:2: ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) otherlv_2= ';' )
            {
            // InternalReflex.g:760:2: ( (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) otherlv_2= ';' )
            // InternalReflex.g:761:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable ) otherlv_2= ';'
            {
            // InternalReflex.g:761:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable )
            int alt14=2;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // InternalReflex.g:762:4: this_PhysicalVariable_0= rulePhysicalVariable
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
                    // InternalReflex.g:771:4: this_ProgramVariable_1= ruleProgramVariable
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

            otherlv_2=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:788:1: entryRulePhysicalVariable returns [EObject current=null] : iv_rulePhysicalVariable= rulePhysicalVariable EOF ;
    public final EObject entryRulePhysicalVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePhysicalVariable = null;


        try {
            // InternalReflex.g:788:57: (iv_rulePhysicalVariable= rulePhysicalVariable EOF )
            // InternalReflex.g:789:2: iv_rulePhysicalVariable= rulePhysicalVariable EOF
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
    // InternalReflex.g:795:1: rulePhysicalVariable returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_port_3_0= ruleRegisterPortMapping ) ) ) ;
    public final EObject rulePhysicalVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_type_0_0 = null;

        EObject lv_port_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:801:2: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_port_3_0= ruleRegisterPortMapping ) ) ) )
            // InternalReflex.g:802:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_port_3_0= ruleRegisterPortMapping ) ) )
            {
            // InternalReflex.g:802:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_port_3_0= ruleRegisterPortMapping ) ) )
            // InternalReflex.g:803:3: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' ( (lv_port_3_0= ruleRegisterPortMapping ) )
            {
            // InternalReflex.g:803:3: ( (lv_type_0_0= ruleType ) )
            // InternalReflex.g:804:4: (lv_type_0_0= ruleType )
            {
            // InternalReflex.g:804:4: (lv_type_0_0= ruleType )
            // InternalReflex.g:805:5: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPhysicalVariableAccess().getTypeTypeParserRuleCall_0_0());
              				
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

            // InternalReflex.g:822:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:823:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:823:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:824:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_22); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,45,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getPhysicalVariableAccess().getEqualsSignKeyword_2());
              		
            }
            // InternalReflex.g:844:3: ( (lv_port_3_0= ruleRegisterPortMapping ) )
            // InternalReflex.g:845:4: (lv_port_3_0= ruleRegisterPortMapping )
            {
            // InternalReflex.g:845:4: (lv_port_3_0= ruleRegisterPortMapping )
            // InternalReflex.g:846:5: lv_port_3_0= ruleRegisterPortMapping
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPhysicalVariableAccess().getPortRegisterPortMappingParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_port_3_0=ruleRegisterPortMapping();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPhysicalVariableRule());
              					}
              					set(
              						current,
              						"port",
              						lv_port_3_0,
              						"ru.iaie.reflex.Reflex.RegisterPortMapping");
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


    // $ANTLR start "entryRuleRegisterPortMapping"
    // InternalReflex.g:867:1: entryRuleRegisterPortMapping returns [EObject current=null] : iv_ruleRegisterPortMapping= ruleRegisterPortMapping EOF ;
    public final EObject entryRuleRegisterPortMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegisterPortMapping = null;


        try {
            // InternalReflex.g:867:60: (iv_ruleRegisterPortMapping= ruleRegisterPortMapping EOF )
            // InternalReflex.g:868:2: iv_ruleRegisterPortMapping= ruleRegisterPortMapping EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRegisterPortMappingRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRegisterPortMapping=ruleRegisterPortMapping();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRegisterPortMapping; 
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
    // $ANTLR end "entryRuleRegisterPortMapping"


    // $ANTLR start "ruleRegisterPortMapping"
    // InternalReflex.g:874:1: ruleRegisterPortMapping returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_portBit_2_0= RULE_INTEGER ) ) otherlv_3= ']' )? ) ;
    public final EObject ruleRegisterPortMapping() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_portBit_2_0=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalReflex.g:880:2: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_portBit_2_0= RULE_INTEGER ) ) otherlv_3= ']' )? ) )
            // InternalReflex.g:881:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_portBit_2_0= RULE_INTEGER ) ) otherlv_3= ']' )? )
            {
            // InternalReflex.g:881:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_portBit_2_0= RULE_INTEGER ) ) otherlv_3= ']' )? )
            // InternalReflex.g:882:3: ( (otherlv_0= RULE_ID ) ) (otherlv_1= '[' ( (lv_portBit_2_0= RULE_INTEGER ) ) otherlv_3= ']' )?
            {
            // InternalReflex.g:882:3: ( (otherlv_0= RULE_ID ) )
            // InternalReflex.g:883:4: (otherlv_0= RULE_ID )
            {
            // InternalReflex.g:883:4: (otherlv_0= RULE_ID )
            // InternalReflex.g:884:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRegisterPortMappingRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getRegisterPortMappingAccess().getRegisterRegisterCrossReference_0_0());
              				
            }

            }


            }

            // InternalReflex.g:895:3: (otherlv_1= '[' ( (lv_portBit_2_0= RULE_INTEGER ) ) otherlv_3= ']' )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==32) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // InternalReflex.g:896:4: otherlv_1= '[' ( (lv_portBit_2_0= RULE_INTEGER ) ) otherlv_3= ']'
                    {
                    otherlv_1=(Token)match(input,32,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getRegisterPortMappingAccess().getLeftSquareBracketKeyword_1_0());
                      			
                    }
                    // InternalReflex.g:900:4: ( (lv_portBit_2_0= RULE_INTEGER ) )
                    // InternalReflex.g:901:5: (lv_portBit_2_0= RULE_INTEGER )
                    {
                    // InternalReflex.g:901:5: (lv_portBit_2_0= RULE_INTEGER )
                    // InternalReflex.g:902:6: lv_portBit_2_0= RULE_INTEGER
                    {
                    lv_portBit_2_0=(Token)match(input,RULE_INTEGER,FOLLOW_4); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_portBit_2_0, grammarAccess.getRegisterPortMappingAccess().getPortBitINTEGERTerminalRuleCall_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getRegisterPortMappingRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"portBit",
                      							lv_portBit_2_0,
                      							"ru.iaie.reflex.Reflex.INTEGER");
                      					
                    }

                    }


                    }

                    otherlv_3=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getRegisterPortMappingAccess().getRightSquareBracketKeyword_1_2());
                      			
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
    // $ANTLR end "ruleRegisterPortMapping"


    // $ANTLR start "entryRuleProgramVariable"
    // InternalReflex.g:927:1: entryRuleProgramVariable returns [EObject current=null] : iv_ruleProgramVariable= ruleProgramVariable EOF ;
    public final EObject entryRuleProgramVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgramVariable = null;


        try {
            // InternalReflex.g:927:56: (iv_ruleProgramVariable= ruleProgramVariable EOF )
            // InternalReflex.g:928:2: iv_ruleProgramVariable= ruleProgramVariable EOF
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
    // InternalReflex.g:934:1: ruleProgramVariable returns [EObject current=null] : ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleProgramVariable() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:940:2: ( ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalReflex.g:941:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalReflex.g:941:2: ( ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalReflex.g:942:3: ( (lv_type_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalReflex.g:942:3: ( (lv_type_0_0= ruleType ) )
            // InternalReflex.g:943:4: (lv_type_0_0= ruleType )
            {
            // InternalReflex.g:943:4: (lv_type_0_0= ruleType )
            // InternalReflex.g:944:5: lv_type_0_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getProgramVariableAccess().getTypeTypeParserRuleCall_0_0());
              				
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

            // InternalReflex.g:961:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:962:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:962:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:963:5: lv_name_1_0= RULE_ID
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


    // $ANTLR start "entryRuleStatementSequence"
    // InternalReflex.g:983:1: entryRuleStatementSequence returns [EObject current=null] : iv_ruleStatementSequence= ruleStatementSequence EOF ;
    public final EObject entryRuleStatementSequence() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatementSequence = null;


        try {
            // InternalReflex.g:983:58: (iv_ruleStatementSequence= ruleStatementSequence EOF )
            // InternalReflex.g:984:2: iv_ruleStatementSequence= ruleStatementSequence EOF
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
    // InternalReflex.g:990:1: ruleStatementSequence returns [EObject current=null] : ( () ( (lv_statements_1_0= ruleStatement ) )* ) ;
    public final EObject ruleStatementSequence() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_1_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:996:2: ( ( () ( (lv_statements_1_0= ruleStatement ) )* ) )
            // InternalReflex.g:997:2: ( () ( (lv_statements_1_0= ruleStatement ) )* )
            {
            // InternalReflex.g:997:2: ( () ( (lv_statements_1_0= ruleStatement ) )* )
            // InternalReflex.g:998:3: () ( (lv_statements_1_0= ruleStatement ) )*
            {
            // InternalReflex.g:998:3: ()
            // InternalReflex.g:999:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getStatementSequenceAccess().getStatementSequenceAction_0(),
              					current);
              			
            }

            }

            // InternalReflex.g:1005:3: ( (lv_statements_1_0= ruleStatement ) )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( ((LA16_0>=RULE_ID && LA16_0<=RULE_FLOAT)||LA16_0==35||(LA16_0>=38 && LA16_0<=39)||LA16_0==47||LA16_0==49||LA16_0==51||(LA16_0>=55 && LA16_0<=59)||LA16_0==61||(LA16_0>=71 && LA16_0<=72)||(LA16_0>=82 && LA16_0<=85)||(LA16_0>=97 && LA16_0<=98)) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // InternalReflex.g:1006:4: (lv_statements_1_0= ruleStatement )
            	    {
            	    // InternalReflex.g:1006:4: (lv_statements_1_0= ruleStatement )
            	    // InternalReflex.g:1007:5: lv_statements_1_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getStatementSequenceAccess().getStatementsStatementParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_24);
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
            	    break loop16;
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
    // InternalReflex.g:1028:1: entryRuleCompoundStatement returns [EObject current=null] : iv_ruleCompoundStatement= ruleCompoundStatement EOF ;
    public final EObject entryRuleCompoundStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompoundStatement = null;


        try {
            // InternalReflex.g:1028:58: (iv_ruleCompoundStatement= ruleCompoundStatement EOF )
            // InternalReflex.g:1029:2: iv_ruleCompoundStatement= ruleCompoundStatement EOF
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
    // InternalReflex.g:1035:1: ruleCompoundStatement returns [EObject current=null] : ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) ;
    public final EObject ruleCompoundStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_statements_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1041:2: ( ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' ) )
            // InternalReflex.g:1042:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' )
            {
            // InternalReflex.g:1042:2: ( () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}' )
            // InternalReflex.g:1043:3: () otherlv_1= '{' ( (lv_statements_2_0= ruleStatement ) )* otherlv_3= '}'
            {
            // InternalReflex.g:1043:3: ()
            // InternalReflex.g:1044:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getCompoundStatementAccess().getStatementBlockAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,35,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getCompoundStatementAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalReflex.g:1054:3: ( (lv_statements_2_0= ruleStatement ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>=RULE_ID && LA17_0<=RULE_FLOAT)||LA17_0==35||(LA17_0>=38 && LA17_0<=39)||LA17_0==47||LA17_0==49||LA17_0==51||(LA17_0>=55 && LA17_0<=59)||LA17_0==61||(LA17_0>=71 && LA17_0<=72)||(LA17_0>=82 && LA17_0<=85)||(LA17_0>=97 && LA17_0<=98)) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalReflex.g:1055:4: (lv_statements_2_0= ruleStatement )
            	    {
            	    // InternalReflex.g:1055:4: (lv_statements_2_0= ruleStatement )
            	    // InternalReflex.g:1056:5: lv_statements_2_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getCompoundStatementAccess().getStatementsStatementParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_25);
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
            	    break loop17;
                }
            } while (true);

            otherlv_3=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleTimeoutFunction"
    // InternalReflex.g:1081:1: entryRuleTimeoutFunction returns [EObject current=null] : iv_ruleTimeoutFunction= ruleTimeoutFunction EOF ;
    public final EObject entryRuleTimeoutFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeoutFunction = null;


        try {
            // InternalReflex.g:1081:56: (iv_ruleTimeoutFunction= ruleTimeoutFunction EOF )
            // InternalReflex.g:1082:2: iv_ruleTimeoutFunction= ruleTimeoutFunction EOF
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
    // InternalReflex.g:1088:1: ruleTimeoutFunction returns [EObject current=null] : (otherlv_0= 'timeout' (this_TimeAmountOrRef_1= ruleTimeAmountOrRef[$current] | (otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')' ) ) ( (lv_body_5_0= ruleStatement ) ) ) ;
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
            // InternalReflex.g:1094:2: ( (otherlv_0= 'timeout' (this_TimeAmountOrRef_1= ruleTimeAmountOrRef[$current] | (otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')' ) ) ( (lv_body_5_0= ruleStatement ) ) ) )
            // InternalReflex.g:1095:2: (otherlv_0= 'timeout' (this_TimeAmountOrRef_1= ruleTimeAmountOrRef[$current] | (otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')' ) ) ( (lv_body_5_0= ruleStatement ) ) )
            {
            // InternalReflex.g:1095:2: (otherlv_0= 'timeout' (this_TimeAmountOrRef_1= ruleTimeAmountOrRef[$current] | (otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')' ) ) ( (lv_body_5_0= ruleStatement ) ) )
            // InternalReflex.g:1096:3: otherlv_0= 'timeout' (this_TimeAmountOrRef_1= ruleTimeAmountOrRef[$current] | (otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')' ) ) ( (lv_body_5_0= ruleStatement ) )
            {
            otherlv_0=(Token)match(input,46,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getTimeoutFunctionAccess().getTimeoutKeyword_0());
              		
            }
            // InternalReflex.g:1100:3: (this_TimeAmountOrRef_1= ruleTimeAmountOrRef[$current] | (otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')' ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=RULE_ID && LA18_0<=RULE_INTEGER)) ) {
                alt18=1;
            }
            else if ( (LA18_0==47) ) {
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
                    // InternalReflex.g:1101:4: this_TimeAmountOrRef_1= ruleTimeAmountOrRef[$current]
                    {
                    if ( state.backtracking==0 ) {

                      				if (current==null) {
                      					current = createModelElement(grammarAccess.getTimeoutFunctionRule());
                      				}
                      				newCompositeNode(grammarAccess.getTimeoutFunctionAccess().getTimeAmountOrRefParserRuleCall_1_0());
                      			
                    }
                    pushFollow(FOLLOW_27);
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
                    // InternalReflex.g:1113:4: (otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')' )
                    {
                    // InternalReflex.g:1113:4: (otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')' )
                    // InternalReflex.g:1114:5: otherlv_2= '(' this_TimeAmountOrRef_3= ruleTimeAmountOrRef[$current] otherlv_4= ')'
                    {
                    otherlv_2=(Token)match(input,47,FOLLOW_28); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_2, grammarAccess.getTimeoutFunctionAccess().getLeftParenthesisKeyword_1_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getTimeoutFunctionRule());
                      					}
                      					newCompositeNode(grammarAccess.getTimeoutFunctionAccess().getTimeAmountOrRefParserRuleCall_1_1_1());
                      				
                    }
                    pushFollow(FOLLOW_29);
                    this_TimeAmountOrRef_3=ruleTimeAmountOrRef(current);

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					current = this_TimeAmountOrRef_3;
                      					afterParserOrEnumRuleCall();
                      				
                    }
                    otherlv_4=(Token)match(input,48,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getTimeoutFunctionAccess().getRightParenthesisKeyword_1_1_2());
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalReflex.g:1135:3: ( (lv_body_5_0= ruleStatement ) )
            // InternalReflex.g:1136:4: (lv_body_5_0= ruleStatement )
            {
            // InternalReflex.g:1136:4: (lv_body_5_0= ruleStatement )
            // InternalReflex.g:1137:5: lv_body_5_0= ruleStatement
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
    // InternalReflex.g:1159:1: ruleTimeAmountOrRef[EObject in_current] returns [EObject current=in_current] : ( ( (lv_time_0_0= ruleTime ) ) | ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleTimeAmountOrRef(EObject in_current) throws RecognitionException {
        EObject current = in_current;

        Token otherlv_1=null;
        EObject lv_time_0_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1165:2: ( ( ( (lv_time_0_0= ruleTime ) ) | ( (otherlv_1= RULE_ID ) ) ) )
            // InternalReflex.g:1166:2: ( ( (lv_time_0_0= ruleTime ) ) | ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalReflex.g:1166:2: ( ( (lv_time_0_0= ruleTime ) ) | ( (otherlv_1= RULE_ID ) ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_INTEGER) ) {
                alt19=1;
            }
            else if ( (LA19_0==RULE_ID) ) {
                alt19=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // InternalReflex.g:1167:3: ( (lv_time_0_0= ruleTime ) )
                    {
                    // InternalReflex.g:1167:3: ( (lv_time_0_0= ruleTime ) )
                    // InternalReflex.g:1168:4: (lv_time_0_0= ruleTime )
                    {
                    // InternalReflex.g:1168:4: (lv_time_0_0= ruleTime )
                    // InternalReflex.g:1169:5: lv_time_0_0= ruleTime
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getTimeAmountOrRefAccess().getTimeTimeParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_time_0_0=ruleTime();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getTimeAmountOrRefRule());
                      					}
                      					set(
                      						current,
                      						"time",
                      						lv_time_0_0,
                      						"ru.iaie.reflex.Reflex.Time");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:1187:3: ( (otherlv_1= RULE_ID ) )
                    {
                    // InternalReflex.g:1187:3: ( (otherlv_1= RULE_ID ) )
                    // InternalReflex.g:1188:4: (otherlv_1= RULE_ID )
                    {
                    // InternalReflex.g:1188:4: (otherlv_1= RULE_ID )
                    // InternalReflex.g:1189:5: otherlv_1= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getTimeAmountOrRefRule());
                      					}
                      				
                    }
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_1, grammarAccess.getTimeAmountOrRefAccess().getRefIdReferenceCrossReference_1_0());
                      				
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


    // $ANTLR start "entryRuleStatement"
    // InternalReflex.g:1204:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalReflex.g:1204:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalReflex.g:1205:2: iv_ruleStatement= ruleStatement EOF
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
    // InternalReflex.g:1211:1: ruleStatement returns [EObject current=null] : ( ( () otherlv_1= ';' ) | this_CompoundStatement_2= ruleCompoundStatement | this_StartProcStat_3= ruleStartProcStat | this_StopProcStat_4= ruleStopProcStat | this_ErrorStat_5= ruleErrorStat | this_RestartStat_6= ruleRestartStat | this_ResetStat_7= ruleResetStat | this_SetStateStat_8= ruleSetStateStat | this_IfElseStat_9= ruleIfElseStat | this_SwitchStat_10= ruleSwitchStat | (this_Expression_11= ruleExpression otherlv_12= ';' ) ) ;
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
            // InternalReflex.g:1217:2: ( ( ( () otherlv_1= ';' ) | this_CompoundStatement_2= ruleCompoundStatement | this_StartProcStat_3= ruleStartProcStat | this_StopProcStat_4= ruleStopProcStat | this_ErrorStat_5= ruleErrorStat | this_RestartStat_6= ruleRestartStat | this_ResetStat_7= ruleResetStat | this_SetStateStat_8= ruleSetStateStat | this_IfElseStat_9= ruleIfElseStat | this_SwitchStat_10= ruleSwitchStat | (this_Expression_11= ruleExpression otherlv_12= ';' ) ) )
            // InternalReflex.g:1218:2: ( ( () otherlv_1= ';' ) | this_CompoundStatement_2= ruleCompoundStatement | this_StartProcStat_3= ruleStartProcStat | this_StopProcStat_4= ruleStopProcStat | this_ErrorStat_5= ruleErrorStat | this_RestartStat_6= ruleRestartStat | this_ResetStat_7= ruleResetStat | this_SetStateStat_8= ruleSetStateStat | this_IfElseStat_9= ruleIfElseStat | this_SwitchStat_10= ruleSwitchStat | (this_Expression_11= ruleExpression otherlv_12= ';' ) )
            {
            // InternalReflex.g:1218:2: ( ( () otherlv_1= ';' ) | this_CompoundStatement_2= ruleCompoundStatement | this_StartProcStat_3= ruleStartProcStat | this_StopProcStat_4= ruleStopProcStat | this_ErrorStat_5= ruleErrorStat | this_RestartStat_6= ruleRestartStat | this_ResetStat_7= ruleResetStat | this_SetStateStat_8= ruleSetStateStat | this_IfElseStat_9= ruleIfElseStat | this_SwitchStat_10= ruleSwitchStat | (this_Expression_11= ruleExpression otherlv_12= ';' ) )
            int alt20=11;
            switch ( input.LA(1) ) {
            case 38:
                {
                alt20=1;
                }
                break;
            case 35:
                {
                alt20=2;
                }
                break;
            case 55:
                {
                alt20=3;
                }
                break;
            case 56:
                {
                alt20=4;
                }
                break;
            case 57:
                {
                alt20=5;
                }
                break;
            case 58:
                {
                alt20=6;
                }
                break;
            case 59:
                {
                alt20=7;
                }
                break;
            case 61:
                {
                alt20=8;
                }
                break;
            case 49:
                {
                alt20=9;
                }
                break;
            case 51:
                {
                alt20=10;
                }
                break;
            case RULE_ID:
            case RULE_INTEGER:
            case RULE_FLOAT:
            case 39:
            case 47:
            case 71:
            case 72:
            case 82:
            case 83:
            case 84:
            case 85:
            case 97:
            case 98:
                {
                alt20=11;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // InternalReflex.g:1219:3: ( () otherlv_1= ';' )
                    {
                    // InternalReflex.g:1219:3: ( () otherlv_1= ';' )
                    // InternalReflex.g:1220:4: () otherlv_1= ';'
                    {
                    // InternalReflex.g:1220:4: ()
                    // InternalReflex.g:1221:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getStatementAccess().getStatementAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getStatementAccess().getSemicolonKeyword_0_1());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:1233:3: this_CompoundStatement_2= ruleCompoundStatement
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
                    // InternalReflex.g:1242:3: this_StartProcStat_3= ruleStartProcStat
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
                    // InternalReflex.g:1251:3: this_StopProcStat_4= ruleStopProcStat
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
                    // InternalReflex.g:1260:3: this_ErrorStat_5= ruleErrorStat
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
                    // InternalReflex.g:1269:3: this_RestartStat_6= ruleRestartStat
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
                    // InternalReflex.g:1278:3: this_ResetStat_7= ruleResetStat
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
                    // InternalReflex.g:1287:3: this_SetStateStat_8= ruleSetStateStat
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
                    // InternalReflex.g:1296:3: this_IfElseStat_9= ruleIfElseStat
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
                    // InternalReflex.g:1305:3: this_SwitchStat_10= ruleSwitchStat
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
                    // InternalReflex.g:1314:3: (this_Expression_11= ruleExpression otherlv_12= ';' )
                    {
                    // InternalReflex.g:1314:3: (this_Expression_11= ruleExpression otherlv_12= ';' )
                    // InternalReflex.g:1315:4: this_Expression_11= ruleExpression otherlv_12= ';'
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
                    otherlv_12=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleIfElseStat"
    // InternalReflex.g:1332:1: entryRuleIfElseStat returns [EObject current=null] : iv_ruleIfElseStat= ruleIfElseStat EOF ;
    public final EObject entryRuleIfElseStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfElseStat = null;


        try {
            // InternalReflex.g:1332:51: (iv_ruleIfElseStat= ruleIfElseStat EOF )
            // InternalReflex.g:1333:2: iv_ruleIfElseStat= ruleIfElseStat EOF
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
    // InternalReflex.g:1339:1: ruleIfElseStat returns [EObject current=null] : (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )? ) ;
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
            // InternalReflex.g:1345:2: ( (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )? ) )
            // InternalReflex.g:1346:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )? )
            {
            // InternalReflex.g:1346:2: (otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )? )
            // InternalReflex.g:1347:3: otherlv_0= 'if' otherlv_1= '(' ( (lv_cond_2_0= ruleExpression ) ) otherlv_3= ')' ( (lv_then_4_0= ruleStatement ) ) ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )?
            {
            otherlv_0=(Token)match(input,49,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIfElseStatAccess().getIfKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,47,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getIfElseStatAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalReflex.g:1355:3: ( (lv_cond_2_0= ruleExpression ) )
            // InternalReflex.g:1356:4: (lv_cond_2_0= ruleExpression )
            {
            // InternalReflex.g:1356:4: (lv_cond_2_0= ruleExpression )
            // InternalReflex.g:1357:5: lv_cond_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfElseStatAccess().getCondExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_29);
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

            otherlv_3=(Token)match(input,48,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getIfElseStatAccess().getRightParenthesisKeyword_3());
              		
            }
            // InternalReflex.g:1378:3: ( (lv_then_4_0= ruleStatement ) )
            // InternalReflex.g:1379:4: (lv_then_4_0= ruleStatement )
            {
            // InternalReflex.g:1379:4: (lv_then_4_0= ruleStatement )
            // InternalReflex.g:1380:5: lv_then_4_0= ruleStatement
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfElseStatAccess().getThenStatementParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_31);
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

            // InternalReflex.g:1397:3: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==50) ) {
                int LA21_1 = input.LA(2);

                if ( (synpred1_InternalReflex()) ) {
                    alt21=1;
                }
            }
            switch (alt21) {
                case 1 :
                    // InternalReflex.g:1398:4: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_else_6_0= ruleStatement ) )
                    {
                    // InternalReflex.g:1398:4: ( ( 'else' )=>otherlv_5= 'else' )
                    // InternalReflex.g:1399:5: ( 'else' )=>otherlv_5= 'else'
                    {
                    otherlv_5=(Token)match(input,50,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getIfElseStatAccess().getElseKeyword_5_0());
                      				
                    }

                    }

                    // InternalReflex.g:1405:4: ( (lv_else_6_0= ruleStatement ) )
                    // InternalReflex.g:1406:5: (lv_else_6_0= ruleStatement )
                    {
                    // InternalReflex.g:1406:5: (lv_else_6_0= ruleStatement )
                    // InternalReflex.g:1407:6: lv_else_6_0= ruleStatement
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
    // InternalReflex.g:1429:1: entryRuleSwitchStat returns [EObject current=null] : iv_ruleSwitchStat= ruleSwitchStat EOF ;
    public final EObject entryRuleSwitchStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSwitchStat = null;


        try {
            // InternalReflex.g:1429:51: (iv_ruleSwitchStat= ruleSwitchStat EOF )
            // InternalReflex.g:1430:2: iv_ruleSwitchStat= ruleSwitchStat EOF
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
    // InternalReflex.g:1436:1: ruleSwitchStat returns [EObject current=null] : (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* otherlv_6= '}' ) ;
    public final EObject ruleSwitchStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_expr_2_0 = null;

        EObject lv_options_5_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1442:2: ( (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* otherlv_6= '}' ) )
            // InternalReflex.g:1443:2: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* otherlv_6= '}' )
            {
            // InternalReflex.g:1443:2: (otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* otherlv_6= '}' )
            // InternalReflex.g:1444:3: otherlv_0= 'switch' otherlv_1= '(' ( (lv_expr_2_0= ruleExpression ) ) otherlv_3= ')' otherlv_4= '{' ( (lv_options_5_0= ruleCaseStat ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,51,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getSwitchStatAccess().getSwitchKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,47,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSwitchStatAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalReflex.g:1452:3: ( (lv_expr_2_0= ruleExpression ) )
            // InternalReflex.g:1453:4: (lv_expr_2_0= ruleExpression )
            {
            // InternalReflex.g:1453:4: (lv_expr_2_0= ruleExpression )
            // InternalReflex.g:1454:5: lv_expr_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSwitchStatAccess().getExprExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_29);
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

            otherlv_3=(Token)match(input,48,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getSwitchStatAccess().getRightParenthesisKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,35,FOLLOW_32); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getSwitchStatAccess().getLeftCurlyBracketKeyword_4());
              		
            }
            // InternalReflex.g:1479:3: ( (lv_options_5_0= ruleCaseStat ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==52) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalReflex.g:1480:4: (lv_options_5_0= ruleCaseStat )
            	    {
            	    // InternalReflex.g:1480:4: (lv_options_5_0= ruleCaseStat )
            	    // InternalReflex.g:1481:5: lv_options_5_0= ruleCaseStat
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getSwitchStatAccess().getOptionsCaseStatParserRuleCall_5_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_32);
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
            	    break loop22;
                }
            } while (true);

            otherlv_6=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getSwitchStatAccess().getRightCurlyBracketKeyword_6());
              		
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
    // InternalReflex.g:1506:1: entryRuleCaseStat returns [EObject current=null] : iv_ruleCaseStat= ruleCaseStat EOF ;
    public final EObject entryRuleCaseStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCaseStat = null;


        try {
            // InternalReflex.g:1506:49: (iv_ruleCaseStat= ruleCaseStat EOF )
            // InternalReflex.g:1507:2: iv_ruleCaseStat= ruleCaseStat EOF
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
    // InternalReflex.g:1513:1: ruleCaseStat returns [EObject current=null] : (otherlv_0= 'case' ( (lv_option_1_0= RULE_INTEGER ) ) otherlv_2= ':' ( (lv_body_3_0= ruleStatementSequence ) ) ( (lv_hasBreak_4_0= ruleBreakStat ) ) otherlv_5= '}' ) ;
    public final EObject ruleCaseStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_option_1_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        EObject lv_body_3_0 = null;

        AntlrDatatypeRuleToken lv_hasBreak_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1519:2: ( (otherlv_0= 'case' ( (lv_option_1_0= RULE_INTEGER ) ) otherlv_2= ':' ( (lv_body_3_0= ruleStatementSequence ) ) ( (lv_hasBreak_4_0= ruleBreakStat ) ) otherlv_5= '}' ) )
            // InternalReflex.g:1520:2: (otherlv_0= 'case' ( (lv_option_1_0= RULE_INTEGER ) ) otherlv_2= ':' ( (lv_body_3_0= ruleStatementSequence ) ) ( (lv_hasBreak_4_0= ruleBreakStat ) ) otherlv_5= '}' )
            {
            // InternalReflex.g:1520:2: (otherlv_0= 'case' ( (lv_option_1_0= RULE_INTEGER ) ) otherlv_2= ':' ( (lv_body_3_0= ruleStatementSequence ) ) ( (lv_hasBreak_4_0= ruleBreakStat ) ) otherlv_5= '}' )
            // InternalReflex.g:1521:3: otherlv_0= 'case' ( (lv_option_1_0= RULE_INTEGER ) ) otherlv_2= ':' ( (lv_body_3_0= ruleStatementSequence ) ) ( (lv_hasBreak_4_0= ruleBreakStat ) ) otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,52,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getCaseStatAccess().getCaseKeyword_0());
              		
            }
            // InternalReflex.g:1525:3: ( (lv_option_1_0= RULE_INTEGER ) )
            // InternalReflex.g:1526:4: (lv_option_1_0= RULE_INTEGER )
            {
            // InternalReflex.g:1526:4: (lv_option_1_0= RULE_INTEGER )
            // InternalReflex.g:1527:5: lv_option_1_0= RULE_INTEGER
            {
            lv_option_1_0=(Token)match(input,RULE_INTEGER,FOLLOW_33); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_option_1_0, grammarAccess.getCaseStatAccess().getOptionINTEGERTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getCaseStatRule());
              					}
              					setWithLastConsumed(
              						current,
              						"option",
              						lv_option_1_0,
              						"ru.iaie.reflex.Reflex.INTEGER");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,53,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getCaseStatAccess().getColonKeyword_2());
              		
            }
            // InternalReflex.g:1547:3: ( (lv_body_3_0= ruleStatementSequence ) )
            // InternalReflex.g:1548:4: (lv_body_3_0= ruleStatementSequence )
            {
            // InternalReflex.g:1548:4: (lv_body_3_0= ruleStatementSequence )
            // InternalReflex.g:1549:5: lv_body_3_0= ruleStatementSequence
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCaseStatAccess().getBodyStatementSequenceParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_34);
            lv_body_3_0=ruleStatementSequence();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCaseStatRule());
              					}
              					set(
              						current,
              						"body",
              						lv_body_3_0,
              						"ru.iaie.reflex.Reflex.StatementSequence");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:1566:3: ( (lv_hasBreak_4_0= ruleBreakStat ) )
            // InternalReflex.g:1567:4: (lv_hasBreak_4_0= ruleBreakStat )
            {
            // InternalReflex.g:1567:4: (lv_hasBreak_4_0= ruleBreakStat )
            // InternalReflex.g:1568:5: lv_hasBreak_4_0= ruleBreakStat
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getCaseStatAccess().getHasBreakBreakStatParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_18);
            lv_hasBreak_4_0=ruleBreakStat();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getCaseStatRule());
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

            otherlv_5=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleBreakStat"
    // InternalReflex.g:1593:1: entryRuleBreakStat returns [String current=null] : iv_ruleBreakStat= ruleBreakStat EOF ;
    public final String entryRuleBreakStat() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBreakStat = null;


        try {
            // InternalReflex.g:1593:49: (iv_ruleBreakStat= ruleBreakStat EOF )
            // InternalReflex.g:1594:2: iv_ruleBreakStat= ruleBreakStat EOF
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
    // InternalReflex.g:1600:1: ruleBreakStat returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'break' kw= ';' ) ;
    public final AntlrDatatypeRuleToken ruleBreakStat() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalReflex.g:1606:2: ( (kw= 'break' kw= ';' ) )
            // InternalReflex.g:1607:2: (kw= 'break' kw= ';' )
            {
            // InternalReflex.g:1607:2: (kw= 'break' kw= ';' )
            // InternalReflex.g:1608:3: kw= 'break' kw= ';'
            {
            kw=(Token)match(input,54,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(kw);
              			newLeafNode(kw, grammarAccess.getBreakStatAccess().getBreakKeyword_0());
              		
            }
            kw=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:1622:1: entryRuleStartProcStat returns [EObject current=null] : iv_ruleStartProcStat= ruleStartProcStat EOF ;
    public final EObject entryRuleStartProcStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStartProcStat = null;


        try {
            // InternalReflex.g:1622:54: (iv_ruleStartProcStat= ruleStartProcStat EOF )
            // InternalReflex.g:1623:2: iv_ruleStartProcStat= ruleStartProcStat EOF
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
    // InternalReflex.g:1629:1: ruleStartProcStat returns [EObject current=null] : (otherlv_0= 'start' otherlv_1= 'process' ( (otherlv_2= RULE_ID ) ) otherlv_3= ';' ) ;
    public final EObject ruleStartProcStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalReflex.g:1635:2: ( (otherlv_0= 'start' otherlv_1= 'process' ( (otherlv_2= RULE_ID ) ) otherlv_3= ';' ) )
            // InternalReflex.g:1636:2: (otherlv_0= 'start' otherlv_1= 'process' ( (otherlv_2= RULE_ID ) ) otherlv_3= ';' )
            {
            // InternalReflex.g:1636:2: (otherlv_0= 'start' otherlv_1= 'process' ( (otherlv_2= RULE_ID ) ) otherlv_3= ';' )
            // InternalReflex.g:1637:3: otherlv_0= 'start' otherlv_1= 'process' ( (otherlv_2= RULE_ID ) ) otherlv_3= ';'
            {
            otherlv_0=(Token)match(input,55,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getStartProcStatAccess().getStartKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,39,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getStartProcStatAccess().getProcessKeyword_1());
              		
            }
            // InternalReflex.g:1645:3: ( (otherlv_2= RULE_ID ) )
            // InternalReflex.g:1646:4: (otherlv_2= RULE_ID )
            {
            // InternalReflex.g:1646:4: (otherlv_2= RULE_ID )
            // InternalReflex.g:1647:5: otherlv_2= RULE_ID
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

            otherlv_3=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:1666:1: entryRuleStopProcStat returns [EObject current=null] : iv_ruleStopProcStat= ruleStopProcStat EOF ;
    public final EObject entryRuleStopProcStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStopProcStat = null;


        try {
            // InternalReflex.g:1666:53: (iv_ruleStopProcStat= ruleStopProcStat EOF )
            // InternalReflex.g:1667:2: iv_ruleStopProcStat= ruleStopProcStat EOF
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
    // InternalReflex.g:1673:1: ruleStopProcStat returns [EObject current=null] : ( () otherlv_1= 'stop' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';' ) ;
    public final EObject ruleStopProcStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalReflex.g:1679:2: ( ( () otherlv_1= 'stop' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';' ) )
            // InternalReflex.g:1680:2: ( () otherlv_1= 'stop' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';' )
            {
            // InternalReflex.g:1680:2: ( () otherlv_1= 'stop' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';' )
            // InternalReflex.g:1681:3: () otherlv_1= 'stop' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';'
            {
            // InternalReflex.g:1681:3: ()
            // InternalReflex.g:1682:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getStopProcStatAccess().getStopProcStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,56,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getStopProcStatAccess().getStopKeyword_1());
              		
            }
            // InternalReflex.g:1692:3: (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==39) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalReflex.g:1693:4: otherlv_2= 'process' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,39,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getStopProcStatAccess().getProcessKeyword_2_0());
                      			
                    }
                    // InternalReflex.g:1697:4: ( (otherlv_3= RULE_ID ) )
                    // InternalReflex.g:1698:5: (otherlv_3= RULE_ID )
                    {
                    // InternalReflex.g:1698:5: (otherlv_3= RULE_ID )
                    // InternalReflex.g:1699:6: otherlv_3= RULE_ID
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

            otherlv_4=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:1719:1: entryRuleErrorStat returns [EObject current=null] : iv_ruleErrorStat= ruleErrorStat EOF ;
    public final EObject entryRuleErrorStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleErrorStat = null;


        try {
            // InternalReflex.g:1719:50: (iv_ruleErrorStat= ruleErrorStat EOF )
            // InternalReflex.g:1720:2: iv_ruleErrorStat= ruleErrorStat EOF
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
    // InternalReflex.g:1726:1: ruleErrorStat returns [EObject current=null] : ( () otherlv_1= 'error' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';' ) ;
    public final EObject ruleErrorStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalReflex.g:1732:2: ( ( () otherlv_1= 'error' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';' ) )
            // InternalReflex.g:1733:2: ( () otherlv_1= 'error' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';' )
            {
            // InternalReflex.g:1733:2: ( () otherlv_1= 'error' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';' )
            // InternalReflex.g:1734:3: () otherlv_1= 'error' (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= ';'
            {
            // InternalReflex.g:1734:3: ()
            // InternalReflex.g:1735:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getErrorStatAccess().getErrorStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,57,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getErrorStatAccess().getErrorKeyword_1());
              		
            }
            // InternalReflex.g:1745:3: (otherlv_2= 'process' ( (otherlv_3= RULE_ID ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==39) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalReflex.g:1746:4: otherlv_2= 'process' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,39,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getErrorStatAccess().getProcessKeyword_2_0());
                      			
                    }
                    // InternalReflex.g:1750:4: ( (otherlv_3= RULE_ID ) )
                    // InternalReflex.g:1751:5: (otherlv_3= RULE_ID )
                    {
                    // InternalReflex.g:1751:5: (otherlv_3= RULE_ID )
                    // InternalReflex.g:1752:6: otherlv_3= RULE_ID
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

            otherlv_4=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:1772:1: entryRuleRestartStat returns [EObject current=null] : iv_ruleRestartStat= ruleRestartStat EOF ;
    public final EObject entryRuleRestartStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRestartStat = null;


        try {
            // InternalReflex.g:1772:52: (iv_ruleRestartStat= ruleRestartStat EOF )
            // InternalReflex.g:1773:2: iv_ruleRestartStat= ruleRestartStat EOF
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
    // InternalReflex.g:1779:1: ruleRestartStat returns [EObject current=null] : ( () otherlv_1= 'restart' otherlv_2= ';' ) ;
    public final EObject ruleRestartStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalReflex.g:1785:2: ( ( () otherlv_1= 'restart' otherlv_2= ';' ) )
            // InternalReflex.g:1786:2: ( () otherlv_1= 'restart' otherlv_2= ';' )
            {
            // InternalReflex.g:1786:2: ( () otherlv_1= 'restart' otherlv_2= ';' )
            // InternalReflex.g:1787:3: () otherlv_1= 'restart' otherlv_2= ';'
            {
            // InternalReflex.g:1787:3: ()
            // InternalReflex.g:1788:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getRestartStatAccess().getRestartStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,58,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getRestartStatAccess().getRestartKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:1806:1: entryRuleResetStat returns [EObject current=null] : iv_ruleResetStat= ruleResetStat EOF ;
    public final EObject entryRuleResetStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleResetStat = null;


        try {
            // InternalReflex.g:1806:50: (iv_ruleResetStat= ruleResetStat EOF )
            // InternalReflex.g:1807:2: iv_ruleResetStat= ruleResetStat EOF
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
    // InternalReflex.g:1813:1: ruleResetStat returns [EObject current=null] : ( () otherlv_1= 'reset' otherlv_2= 'timer' otherlv_3= ';' ) ;
    public final EObject ruleResetStat() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalReflex.g:1819:2: ( ( () otherlv_1= 'reset' otherlv_2= 'timer' otherlv_3= ';' ) )
            // InternalReflex.g:1820:2: ( () otherlv_1= 'reset' otherlv_2= 'timer' otherlv_3= ';' )
            {
            // InternalReflex.g:1820:2: ( () otherlv_1= 'reset' otherlv_2= 'timer' otherlv_3= ';' )
            // InternalReflex.g:1821:3: () otherlv_1= 'reset' otherlv_2= 'timer' otherlv_3= ';'
            {
            // InternalReflex.g:1821:3: ()
            // InternalReflex.g:1822:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getResetStatAccess().getResetStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,59,FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getResetStatAccess().getResetKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,60,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getResetStatAccess().getTimerKeyword_2());
              		
            }
            otherlv_3=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:1844:1: entryRuleSetStateStat returns [EObject current=null] : iv_ruleSetStateStat= ruleSetStateStat EOF ;
    public final EObject entryRuleSetStateStat() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSetStateStat = null;


        try {
            // InternalReflex.g:1844:53: (iv_ruleSetStateStat= ruleSetStateStat EOF )
            // InternalReflex.g:1845:2: iv_ruleSetStateStat= ruleSetStateStat EOF
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
    // InternalReflex.g:1851:1: ruleSetStateStat returns [EObject current=null] : ( () otherlv_1= 'set' ( ( ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state' ) | (otherlv_4= 'state' ( (otherlv_5= RULE_ID ) ) ) ) otherlv_6= ';' ) ;
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
            // InternalReflex.g:1857:2: ( ( () otherlv_1= 'set' ( ( ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state' ) | (otherlv_4= 'state' ( (otherlv_5= RULE_ID ) ) ) ) otherlv_6= ';' ) )
            // InternalReflex.g:1858:2: ( () otherlv_1= 'set' ( ( ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state' ) | (otherlv_4= 'state' ( (otherlv_5= RULE_ID ) ) ) ) otherlv_6= ';' )
            {
            // InternalReflex.g:1858:2: ( () otherlv_1= 'set' ( ( ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state' ) | (otherlv_4= 'state' ( (otherlv_5= RULE_ID ) ) ) ) otherlv_6= ';' )
            // InternalReflex.g:1859:3: () otherlv_1= 'set' ( ( ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state' ) | (otherlv_4= 'state' ( (otherlv_5= RULE_ID ) ) ) ) otherlv_6= ';'
            {
            // InternalReflex.g:1859:3: ()
            // InternalReflex.g:1860:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSetStateStatAccess().getSetStateStatAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,61,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSetStateStatAccess().getSetKeyword_1());
              		
            }
            // InternalReflex.g:1870:3: ( ( ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state' ) | (otherlv_4= 'state' ( (otherlv_5= RULE_ID ) ) ) )
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==62) ) {
                alt25=1;
            }
            else if ( (LA25_0==40) ) {
                alt25=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 25, 0, input);

                throw nvae;
            }
            switch (alt25) {
                case 1 :
                    // InternalReflex.g:1871:4: ( ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state' )
                    {
                    // InternalReflex.g:1871:4: ( ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state' )
                    // InternalReflex.g:1872:5: ( (lv_next_2_0= 'next' ) ) otherlv_3= 'state'
                    {
                    // InternalReflex.g:1872:5: ( (lv_next_2_0= 'next' ) )
                    // InternalReflex.g:1873:6: (lv_next_2_0= 'next' )
                    {
                    // InternalReflex.g:1873:6: (lv_next_2_0= 'next' )
                    // InternalReflex.g:1874:7: lv_next_2_0= 'next'
                    {
                    lv_next_2_0=(Token)match(input,62,FOLLOW_38); if (state.failed) return current;
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

                    otherlv_3=(Token)match(input,40,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_3, grammarAccess.getSetStateStatAccess().getStateKeyword_2_0_1());
                      				
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:1892:4: (otherlv_4= 'state' ( (otherlv_5= RULE_ID ) ) )
                    {
                    // InternalReflex.g:1892:4: (otherlv_4= 'state' ( (otherlv_5= RULE_ID ) ) )
                    // InternalReflex.g:1893:5: otherlv_4= 'state' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,40,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_4, grammarAccess.getSetStateStatAccess().getStateKeyword_2_1_0());
                      				
                    }
                    // InternalReflex.g:1897:5: ( (otherlv_5= RULE_ID ) )
                    // InternalReflex.g:1898:6: (otherlv_5= RULE_ID )
                    {
                    // InternalReflex.g:1898:6: (otherlv_5= RULE_ID )
                    // InternalReflex.g:1899:7: otherlv_5= RULE_ID
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

            otherlv_6=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleFunction"
    // InternalReflex.g:1920:1: entryRuleFunction returns [EObject current=null] : iv_ruleFunction= ruleFunction EOF ;
    public final EObject entryRuleFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunction = null;


        try {
            // InternalReflex.g:1920:49: (iv_ruleFunction= ruleFunction EOF )
            // InternalReflex.g:1921:2: iv_ruleFunction= ruleFunction EOF
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
    // InternalReflex.g:1927:1: ruleFunction returns [EObject current=null] : ( ( (lv_returnType_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleType ) ) )* otherlv_6= ')' otherlv_7= ';' ) ;
    public final EObject ruleFunction() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_returnType_0_0 = null;

        EObject lv_argTypes_3_0 = null;

        EObject lv_argTypes_5_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:1933:2: ( ( ( (lv_returnType_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleType ) ) )* otherlv_6= ')' otherlv_7= ';' ) )
            // InternalReflex.g:1934:2: ( ( (lv_returnType_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleType ) ) )* otherlv_6= ')' otherlv_7= ';' )
            {
            // InternalReflex.g:1934:2: ( ( (lv_returnType_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleType ) ) )* otherlv_6= ')' otherlv_7= ';' )
            // InternalReflex.g:1935:3: ( (lv_returnType_0_0= ruleType ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '(' ( (lv_argTypes_3_0= ruleType ) ) (otherlv_4= ',' ( (lv_argTypes_5_0= ruleType ) ) )* otherlv_6= ')' otherlv_7= ';'
            {
            // InternalReflex.g:1935:3: ( (lv_returnType_0_0= ruleType ) )
            // InternalReflex.g:1936:4: (lv_returnType_0_0= ruleType )
            {
            // InternalReflex.g:1936:4: (lv_returnType_0_0= ruleType )
            // InternalReflex.g:1937:5: lv_returnType_0_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFunctionAccess().getReturnTypeTypeParserRuleCall_0_0());
              				
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

            // InternalReflex.g:1954:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:1955:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:1955:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:1956:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_30); if (state.failed) return current;
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

            otherlv_2=(Token)match(input,47,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getFunctionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalReflex.g:1976:3: ( (lv_argTypes_3_0= ruleType ) )
            // InternalReflex.g:1977:4: (lv_argTypes_3_0= ruleType )
            {
            // InternalReflex.g:1977:4: (lv_argTypes_3_0= ruleType )
            // InternalReflex.g:1978:5: lv_argTypes_3_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getFunctionAccess().getArgTypesTypeParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_40);
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

            // InternalReflex.g:1995:3: (otherlv_4= ',' ( (lv_argTypes_5_0= ruleType ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==43) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalReflex.g:1996:4: otherlv_4= ',' ( (lv_argTypes_5_0= ruleType ) )
            	    {
            	    otherlv_4=(Token)match(input,43,FOLLOW_39); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getFunctionAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalReflex.g:2000:4: ( (lv_argTypes_5_0= ruleType ) )
            	    // InternalReflex.g:2001:5: (lv_argTypes_5_0= ruleType )
            	    {
            	    // InternalReflex.g:2001:5: (lv_argTypes_5_0= ruleType )
            	    // InternalReflex.g:2002:6: lv_argTypes_5_0= ruleType
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getFunctionAccess().getArgTypesTypeParserRuleCall_4_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_40);
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
            	    break loop26;
                }
            } while (true);

            otherlv_6=(Token)match(input,48,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getFunctionAccess().getRightParenthesisKeyword_5());
              		
            }
            otherlv_7=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "entryRuleRegister"
    // InternalReflex.g:2032:1: entryRuleRegister returns [EObject current=null] : iv_ruleRegister= ruleRegister EOF ;
    public final EObject entryRuleRegister() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegister = null;


        try {
            // InternalReflex.g:2032:49: (iv_ruleRegister= ruleRegister EOF )
            // InternalReflex.g:2033:2: iv_ruleRegister= ruleRegister EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRegisterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleRegister=ruleRegister();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRegister; 
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
    // $ANTLR end "entryRuleRegister"


    // $ANTLR start "ruleRegister"
    // InternalReflex.g:2039:1: ruleRegister returns [EObject current=null] : ( ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= RULE_INTEGER ) ) ( (lv_addr2_3_0= RULE_INTEGER ) ) ( (lv_regSize_4_0= RULE_INTEGER ) ) otherlv_5= ';' ) ;
    public final EObject ruleRegister() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_addr1_2_0=null;
        Token lv_addr2_3_0=null;
        Token lv_regSize_4_0=null;
        Token otherlv_5=null;
        Enumerator lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2045:2: ( ( ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= RULE_INTEGER ) ) ( (lv_addr2_3_0= RULE_INTEGER ) ) ( (lv_regSize_4_0= RULE_INTEGER ) ) otherlv_5= ';' ) )
            // InternalReflex.g:2046:2: ( ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= RULE_INTEGER ) ) ( (lv_addr2_3_0= RULE_INTEGER ) ) ( (lv_regSize_4_0= RULE_INTEGER ) ) otherlv_5= ';' )
            {
            // InternalReflex.g:2046:2: ( ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= RULE_INTEGER ) ) ( (lv_addr2_3_0= RULE_INTEGER ) ) ( (lv_regSize_4_0= RULE_INTEGER ) ) otherlv_5= ';' )
            // InternalReflex.g:2047:3: ( (lv_type_0_0= ruleRegisterType ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_addr1_2_0= RULE_INTEGER ) ) ( (lv_addr2_3_0= RULE_INTEGER ) ) ( (lv_regSize_4_0= RULE_INTEGER ) ) otherlv_5= ';'
            {
            // InternalReflex.g:2047:3: ( (lv_type_0_0= ruleRegisterType ) )
            // InternalReflex.g:2048:4: (lv_type_0_0= ruleRegisterType )
            {
            // InternalReflex.g:2048:4: (lv_type_0_0= ruleRegisterType )
            // InternalReflex.g:2049:5: lv_type_0_0= ruleRegisterType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getRegisterAccess().getTypeRegisterTypeEnumRuleCall_0_0());
              				
            }
            pushFollow(FOLLOW_3);
            lv_type_0_0=ruleRegisterType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getRegisterRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_0_0,
              						"ru.iaie.reflex.Reflex.RegisterType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalReflex.g:2066:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalReflex.g:2067:4: (lv_name_1_0= RULE_ID )
            {
            // InternalReflex.g:2067:4: (lv_name_1_0= RULE_ID )
            // InternalReflex.g:2068:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getRegisterAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRegisterRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalReflex.g:2084:3: ( (lv_addr1_2_0= RULE_INTEGER ) )
            // InternalReflex.g:2085:4: (lv_addr1_2_0= RULE_INTEGER )
            {
            // InternalReflex.g:2085:4: (lv_addr1_2_0= RULE_INTEGER )
            // InternalReflex.g:2086:5: lv_addr1_2_0= RULE_INTEGER
            {
            lv_addr1_2_0=(Token)match(input,RULE_INTEGER,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_addr1_2_0, grammarAccess.getRegisterAccess().getAddr1INTEGERTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRegisterRule());
              					}
              					setWithLastConsumed(
              						current,
              						"addr1",
              						lv_addr1_2_0,
              						"ru.iaie.reflex.Reflex.INTEGER");
              				
            }

            }


            }

            // InternalReflex.g:2102:3: ( (lv_addr2_3_0= RULE_INTEGER ) )
            // InternalReflex.g:2103:4: (lv_addr2_3_0= RULE_INTEGER )
            {
            // InternalReflex.g:2103:4: (lv_addr2_3_0= RULE_INTEGER )
            // InternalReflex.g:2104:5: lv_addr2_3_0= RULE_INTEGER
            {
            lv_addr2_3_0=(Token)match(input,RULE_INTEGER,FOLLOW_9); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_addr2_3_0, grammarAccess.getRegisterAccess().getAddr2INTEGERTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRegisterRule());
              					}
              					setWithLastConsumed(
              						current,
              						"addr2",
              						lv_addr2_3_0,
              						"ru.iaie.reflex.Reflex.INTEGER");
              				
            }

            }


            }

            // InternalReflex.g:2120:3: ( (lv_regSize_4_0= RULE_INTEGER ) )
            // InternalReflex.g:2121:4: (lv_regSize_4_0= RULE_INTEGER )
            {
            // InternalReflex.g:2121:4: (lv_regSize_4_0= RULE_INTEGER )
            // InternalReflex.g:2122:5: lv_regSize_4_0= RULE_INTEGER
            {
            lv_regSize_4_0=(Token)match(input,RULE_INTEGER,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_regSize_4_0, grammarAccess.getRegisterAccess().getRegSizeINTEGERTerminalRuleCall_4_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getRegisterRule());
              					}
              					setWithLastConsumed(
              						current,
              						"regSize",
              						lv_regSize_4_0,
              						"ru.iaie.reflex.Reflex.INTEGER");
              				
            }

            }


            }

            otherlv_5=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getRegisterAccess().getSemicolonKeyword_5());
              		
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
    // $ANTLR end "ruleRegister"


    // $ANTLR start "entryRuleConst"
    // InternalReflex.g:2146:1: entryRuleConst returns [EObject current=null] : iv_ruleConst= ruleConst EOF ;
    public final EObject entryRuleConst() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConst = null;


        try {
            // InternalReflex.g:2146:46: (iv_ruleConst= ruleConst EOF )
            // InternalReflex.g:2147:2: iv_ruleConst= ruleConst EOF
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
    // InternalReflex.g:2153:1: ruleConst returns [EObject current=null] : (otherlv_0= 'const' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_constValue_4_0= ruleExpression ) ) otherlv_5= ';' ) ;
    public final EObject ruleConst() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_type_1_0 = null;

        EObject lv_constValue_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2159:2: ( (otherlv_0= 'const' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_constValue_4_0= ruleExpression ) ) otherlv_5= ';' ) )
            // InternalReflex.g:2160:2: (otherlv_0= 'const' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_constValue_4_0= ruleExpression ) ) otherlv_5= ';' )
            {
            // InternalReflex.g:2160:2: (otherlv_0= 'const' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_constValue_4_0= ruleExpression ) ) otherlv_5= ';' )
            // InternalReflex.g:2161:3: otherlv_0= 'const' ( (lv_type_1_0= ruleType ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '=' ( (lv_constValue_4_0= ruleExpression ) ) otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,63,FOLLOW_39); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getConstAccess().getConstKeyword_0());
              		
            }
            // InternalReflex.g:2165:3: ( (lv_type_1_0= ruleType ) )
            // InternalReflex.g:2166:4: (lv_type_1_0= ruleType )
            {
            // InternalReflex.g:2166:4: (lv_type_1_0= ruleType )
            // InternalReflex.g:2167:5: lv_type_1_0= ruleType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConstAccess().getTypeTypeParserRuleCall_1_0());
              				
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

            // InternalReflex.g:2184:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalReflex.g:2185:4: (lv_name_2_0= RULE_ID )
            {
            // InternalReflex.g:2185:4: (lv_name_2_0= RULE_ID )
            // InternalReflex.g:2186:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_22); if (state.failed) return current;
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

            otherlv_3=(Token)match(input,45,FOLLOW_27); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getConstAccess().getEqualsSignKeyword_3());
              		
            }
            // InternalReflex.g:2206:3: ( (lv_constValue_4_0= ruleExpression ) )
            // InternalReflex.g:2207:4: (lv_constValue_4_0= ruleExpression )
            {
            // InternalReflex.g:2207:4: (lv_constValue_4_0= ruleExpression )
            // InternalReflex.g:2208:5: lv_constValue_4_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getConstAccess().getConstValueExpressionParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_10);
            lv_constValue_4_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getConstRule());
              					}
              					set(
              						current,
              						"constValue",
              						lv_constValue_4_0,
              						"ru.iaie.reflex.Reflex.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_5=(Token)match(input,38,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:2233:1: entryRuleEnum returns [EObject current=null] : iv_ruleEnum= ruleEnum EOF ;
    public final EObject entryRuleEnum() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnum = null;


        try {
            // InternalReflex.g:2233:45: (iv_ruleEnum= ruleEnum EOF )
            // InternalReflex.g:2234:2: iv_ruleEnum= ruleEnum EOF
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
    // InternalReflex.g:2240:1: ruleEnum returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_identifier_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}' ) ;
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
            // InternalReflex.g:2246:2: ( (otherlv_0= 'enum' ( (lv_identifier_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}' ) )
            // InternalReflex.g:2247:2: (otherlv_0= 'enum' ( (lv_identifier_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}' )
            {
            // InternalReflex.g:2247:2: (otherlv_0= 'enum' ( (lv_identifier_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}' )
            // InternalReflex.g:2248:3: otherlv_0= 'enum' ( (lv_identifier_1_0= RULE_ID ) ) otherlv_2= '{' ( (lv_enumMembers_3_0= ruleEnumMember ) ) (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,64,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getEnumAccess().getEnumKeyword_0());
              		
            }
            // InternalReflex.g:2252:3: ( (lv_identifier_1_0= RULE_ID ) )
            // InternalReflex.g:2253:4: (lv_identifier_1_0= RULE_ID )
            {
            // InternalReflex.g:2253:4: (lv_identifier_1_0= RULE_ID )
            // InternalReflex.g:2254:5: lv_identifier_1_0= RULE_ID
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

            otherlv_2=(Token)match(input,35,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getEnumAccess().getLeftCurlyBracketKeyword_2());
              		
            }
            // InternalReflex.g:2274:3: ( (lv_enumMembers_3_0= ruleEnumMember ) )
            // InternalReflex.g:2275:4: (lv_enumMembers_3_0= ruleEnumMember )
            {
            // InternalReflex.g:2275:4: (lv_enumMembers_3_0= ruleEnumMember )
            // InternalReflex.g:2276:5: lv_enumMembers_3_0= ruleEnumMember
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnumAccess().getEnumMembersEnumMemberParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_41);
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

            // InternalReflex.g:2293:3: (otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==43) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalReflex.g:2294:4: otherlv_4= ',' ( (lv_enumMembers_5_0= ruleEnumMember ) )
            	    {
            	    otherlv_4=(Token)match(input,43,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_4, grammarAccess.getEnumAccess().getCommaKeyword_4_0());
            	      			
            	    }
            	    // InternalReflex.g:2298:4: ( (lv_enumMembers_5_0= ruleEnumMember ) )
            	    // InternalReflex.g:2299:5: (lv_enumMembers_5_0= ruleEnumMember )
            	    {
            	    // InternalReflex.g:2299:5: (lv_enumMembers_5_0= ruleEnumMember )
            	    // InternalReflex.g:2300:6: lv_enumMembers_5_0= ruleEnumMember
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEnumAccess().getEnumMembersEnumMemberParserRuleCall_4_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_41);
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
            	    break loop27;
                }
            } while (true);

            otherlv_6=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:2326:1: entryRuleEnumMember returns [EObject current=null] : iv_ruleEnumMember= ruleEnumMember EOF ;
    public final EObject entryRuleEnumMember() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumMember = null;


        try {
            // InternalReflex.g:2326:51: (iv_ruleEnumMember= ruleEnumMember EOF )
            // InternalReflex.g:2327:2: iv_ruleEnumMember= ruleEnumMember EOF
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
    // InternalReflex.g:2333:1: ruleEnumMember returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )? ) ;
    public final EObject ruleEnumMember() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2339:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )? ) )
            // InternalReflex.g:2340:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )? )
            {
            // InternalReflex.g:2340:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )? )
            // InternalReflex.g:2341:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )?
            {
            // InternalReflex.g:2341:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalReflex.g:2342:4: (lv_name_0_0= RULE_ID )
            {
            // InternalReflex.g:2342:4: (lv_name_0_0= RULE_ID )
            // InternalReflex.g:2343:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_42); if (state.failed) return current;
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

            // InternalReflex.g:2359:3: (otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==45) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalReflex.g:2360:4: otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) )
                    {
                    otherlv_1=(Token)match(input,45,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getEnumMemberAccess().getEqualsSignKeyword_1_0());
                      			
                    }
                    // InternalReflex.g:2364:4: ( (lv_value_2_0= ruleExpression ) )
                    // InternalReflex.g:2365:5: (lv_value_2_0= ruleExpression )
                    {
                    // InternalReflex.g:2365:5: (lv_value_2_0= ruleExpression )
                    // InternalReflex.g:2366:6: lv_value_2_0= ruleExpression
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


    // $ANTLR start "entryRuleInfixOp"
    // InternalReflex.g:2388:1: entryRuleInfixOp returns [EObject current=null] : iv_ruleInfixOp= ruleInfixOp EOF ;
    public final EObject entryRuleInfixOp() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInfixOp = null;


        try {
            // InternalReflex.g:2388:48: (iv_ruleInfixOp= ruleInfixOp EOF )
            // InternalReflex.g:2389:2: iv_ruleInfixOp= ruleInfixOp EOF
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
    // InternalReflex.g:2395:1: ruleInfixOp returns [EObject current=null] : ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (lv_varId_1_0= RULE_ID ) ) ) ;
    public final EObject ruleInfixOp() throws RecognitionException {
        EObject current = null;

        Token lv_varId_1_0=null;
        Enumerator lv_op_0_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2401:2: ( ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (lv_varId_1_0= RULE_ID ) ) ) )
            // InternalReflex.g:2402:2: ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (lv_varId_1_0= RULE_ID ) ) )
            {
            // InternalReflex.g:2402:2: ( ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (lv_varId_1_0= RULE_ID ) ) )
            // InternalReflex.g:2403:3: ( (lv_op_0_0= ruleInfixPostfixOp ) ) ( (lv_varId_1_0= RULE_ID ) )
            {
            // InternalReflex.g:2403:3: ( (lv_op_0_0= ruleInfixPostfixOp ) )
            // InternalReflex.g:2404:4: (lv_op_0_0= ruleInfixPostfixOp )
            {
            // InternalReflex.g:2404:4: (lv_op_0_0= ruleInfixPostfixOp )
            // InternalReflex.g:2405:5: lv_op_0_0= ruleInfixPostfixOp
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

            // InternalReflex.g:2422:3: ( (lv_varId_1_0= RULE_ID ) )
            // InternalReflex.g:2423:4: (lv_varId_1_0= RULE_ID )
            {
            // InternalReflex.g:2423:4: (lv_varId_1_0= RULE_ID )
            // InternalReflex.g:2424:5: lv_varId_1_0= RULE_ID
            {
            lv_varId_1_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_varId_1_0, grammarAccess.getInfixOpAccess().getVarIdIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getInfixOpRule());
              					}
              					setWithLastConsumed(
              						current,
              						"varId",
              						lv_varId_1_0,
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
    // $ANTLR end "ruleInfixOp"


    // $ANTLR start "entryRulePostfixOp"
    // InternalReflex.g:2444:1: entryRulePostfixOp returns [EObject current=null] : iv_rulePostfixOp= rulePostfixOp EOF ;
    public final EObject entryRulePostfixOp() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePostfixOp = null;


        try {
            // InternalReflex.g:2444:50: (iv_rulePostfixOp= rulePostfixOp EOF )
            // InternalReflex.g:2445:2: iv_rulePostfixOp= rulePostfixOp EOF
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
    // InternalReflex.g:2451:1: rulePostfixOp returns [EObject current=null] : ( ( (lv_varId_0_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) ) ;
    public final EObject rulePostfixOp() throws RecognitionException {
        EObject current = null;

        Token lv_varId_0_0=null;
        Enumerator lv_op_1_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2457:2: ( ( ( (lv_varId_0_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) ) )
            // InternalReflex.g:2458:2: ( ( (lv_varId_0_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) )
            {
            // InternalReflex.g:2458:2: ( ( (lv_varId_0_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) ) )
            // InternalReflex.g:2459:3: ( (lv_varId_0_0= RULE_ID ) ) ( (lv_op_1_0= ruleInfixPostfixOp ) )
            {
            // InternalReflex.g:2459:3: ( (lv_varId_0_0= RULE_ID ) )
            // InternalReflex.g:2460:4: (lv_varId_0_0= RULE_ID )
            {
            // InternalReflex.g:2460:4: (lv_varId_0_0= RULE_ID )
            // InternalReflex.g:2461:5: lv_varId_0_0= RULE_ID
            {
            lv_varId_0_0=(Token)match(input,RULE_ID,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_varId_0_0, grammarAccess.getPostfixOpAccess().getVarIdIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getPostfixOpRule());
              					}
              					setWithLastConsumed(
              						current,
              						"varId",
              						lv_varId_0_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            // InternalReflex.g:2477:3: ( (lv_op_1_0= ruleInfixPostfixOp ) )
            // InternalReflex.g:2478:4: (lv_op_1_0= ruleInfixPostfixOp )
            {
            // InternalReflex.g:2478:4: (lv_op_1_0= ruleInfixPostfixOp )
            // InternalReflex.g:2479:5: lv_op_1_0= ruleInfixPostfixOp
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
    // InternalReflex.g:2500:1: entryRuleFunctionCall returns [EObject current=null] : iv_ruleFunctionCall= ruleFunctionCall EOF ;
    public final EObject entryRuleFunctionCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFunctionCall = null;


        try {
            // InternalReflex.g:2500:53: (iv_ruleFunctionCall= ruleFunctionCall EOF )
            // InternalReflex.g:2501:2: iv_ruleFunctionCall= ruleFunctionCall EOF
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
    // InternalReflex.g:2507:1: ruleFunctionCall returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')' ) ;
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
            // InternalReflex.g:2513:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')' ) )
            // InternalReflex.g:2514:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')' )
            {
            // InternalReflex.g:2514:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')' )
            // InternalReflex.g:2515:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )? otherlv_5= ')'
            {
            // InternalReflex.g:2515:3: ( (otherlv_0= RULE_ID ) )
            // InternalReflex.g:2516:4: (otherlv_0= RULE_ID )
            {
            // InternalReflex.g:2516:4: (otherlv_0= RULE_ID )
            // InternalReflex.g:2517:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFunctionCallRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getFunctionCallAccess().getFunctionFunctionCrossReference_0_0());
              				
            }

            }


            }

            otherlv_1=(Token)match(input,47,FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getFunctionCallAccess().getLeftParenthesisKeyword_1());
              		
            }
            // InternalReflex.g:2532:3: ( ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )* )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=RULE_ID && LA30_0<=RULE_FLOAT)||LA30_0==39||LA30_0==47||(LA30_0>=71 && LA30_0<=72)||(LA30_0>=82 && LA30_0<=85)||(LA30_0>=97 && LA30_0<=98)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalReflex.g:2533:4: ( (lv_args_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )*
                    {
                    // InternalReflex.g:2533:4: ( (lv_args_2_0= ruleExpression ) )
                    // InternalReflex.g:2534:5: (lv_args_2_0= ruleExpression )
                    {
                    // InternalReflex.g:2534:5: (lv_args_2_0= ruleExpression )
                    // InternalReflex.g:2535:6: lv_args_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_40);
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

                    // InternalReflex.g:2552:4: (otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) ) )*
                    loop29:
                    do {
                        int alt29=2;
                        int LA29_0 = input.LA(1);

                        if ( (LA29_0==43) ) {
                            alt29=1;
                        }


                        switch (alt29) {
                    	case 1 :
                    	    // InternalReflex.g:2553:5: otherlv_3= ',' ( (lv_args_4_0= ruleExpression ) )
                    	    {
                    	    otherlv_3=(Token)match(input,43,FOLLOW_27); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getFunctionCallAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalReflex.g:2557:5: ( (lv_args_4_0= ruleExpression ) )
                    	    // InternalReflex.g:2558:6: (lv_args_4_0= ruleExpression )
                    	    {
                    	    // InternalReflex.g:2558:6: (lv_args_4_0= ruleExpression )
                    	    // InternalReflex.g:2559:7: lv_args_4_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getFunctionCallAccess().getArgsExpressionParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_40);
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
                    	    break loop29;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:2586:1: entryRuleCheckStateExpression returns [EObject current=null] : iv_ruleCheckStateExpression= ruleCheckStateExpression EOF ;
    public final EObject entryRuleCheckStateExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCheckStateExpression = null;


        try {
            // InternalReflex.g:2586:61: (iv_ruleCheckStateExpression= ruleCheckStateExpression EOF )
            // InternalReflex.g:2587:2: iv_ruleCheckStateExpression= ruleCheckStateExpression EOF
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
    // InternalReflex.g:2593:1: ruleCheckStateExpression returns [EObject current=null] : (otherlv_0= 'process' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'in' otherlv_3= 'state' ( (lv_qualfier_4_0= ruleStateQualifier ) ) ) ;
    public final EObject ruleCheckStateExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Enumerator lv_qualfier_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2599:2: ( (otherlv_0= 'process' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'in' otherlv_3= 'state' ( (lv_qualfier_4_0= ruleStateQualifier ) ) ) )
            // InternalReflex.g:2600:2: (otherlv_0= 'process' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'in' otherlv_3= 'state' ( (lv_qualfier_4_0= ruleStateQualifier ) ) )
            {
            // InternalReflex.g:2600:2: (otherlv_0= 'process' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'in' otherlv_3= 'state' ( (lv_qualfier_4_0= ruleStateQualifier ) ) )
            // InternalReflex.g:2601:3: otherlv_0= 'process' ( (otherlv_1= RULE_ID ) ) otherlv_2= 'in' otherlv_3= 'state' ( (lv_qualfier_4_0= ruleStateQualifier ) )
            {
            otherlv_0=(Token)match(input,39,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getCheckStateExpressionAccess().getProcessKeyword_0());
              		
            }
            // InternalReflex.g:2605:3: ( (otherlv_1= RULE_ID ) )
            // InternalReflex.g:2606:4: (otherlv_1= RULE_ID )
            {
            // InternalReflex.g:2606:4: (otherlv_1= RULE_ID )
            // InternalReflex.g:2607:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getCheckStateExpressionRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_45); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getCheckStateExpressionAccess().getProcessProcessCrossReference_1_0());
              				
            }

            }


            }

            otherlv_2=(Token)match(input,65,FOLLOW_38); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getCheckStateExpressionAccess().getInKeyword_2());
              		
            }
            otherlv_3=(Token)match(input,40,FOLLOW_46); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getCheckStateExpressionAccess().getStateKeyword_3());
              		
            }
            // InternalReflex.g:2626:3: ( (lv_qualfier_4_0= ruleStateQualifier ) )
            // InternalReflex.g:2627:4: (lv_qualfier_4_0= ruleStateQualifier )
            {
            // InternalReflex.g:2627:4: (lv_qualfier_4_0= ruleStateQualifier )
            // InternalReflex.g:2628:5: lv_qualfier_4_0= ruleStateQualifier
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
    // InternalReflex.g:2649:1: entryRulePrimaryExpression returns [EObject current=null] : iv_rulePrimaryExpression= rulePrimaryExpression EOF ;
    public final EObject entryRulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpression = null;


        try {
            // InternalReflex.g:2649:58: (iv_rulePrimaryExpression= rulePrimaryExpression EOF )
            // InternalReflex.g:2650:2: iv_rulePrimaryExpression= rulePrimaryExpression EOF
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
    // InternalReflex.g:2656:1: rulePrimaryExpression returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) | ( () ( (lv_integer_2_0= RULE_INTEGER ) ) ) | ( () ( (lv_floating_4_0= RULE_FLOAT ) ) ) | ( () ( (lv_bool_6_0= ruleBoolLiteral ) ) ) | (otherlv_7= '(' ( (lv_nestedExpr_8_0= ruleExpression ) ) otherlv_9= ')' ) ) ;
    public final EObject rulePrimaryExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_integer_2_0=null;
        Token lv_floating_4_0=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Enumerator lv_bool_6_0 = null;

        EObject lv_nestedExpr_8_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2662:2: ( ( ( (otherlv_0= RULE_ID ) ) | ( () ( (lv_integer_2_0= RULE_INTEGER ) ) ) | ( () ( (lv_floating_4_0= RULE_FLOAT ) ) ) | ( () ( (lv_bool_6_0= ruleBoolLiteral ) ) ) | (otherlv_7= '(' ( (lv_nestedExpr_8_0= ruleExpression ) ) otherlv_9= ')' ) ) )
            // InternalReflex.g:2663:2: ( ( (otherlv_0= RULE_ID ) ) | ( () ( (lv_integer_2_0= RULE_INTEGER ) ) ) | ( () ( (lv_floating_4_0= RULE_FLOAT ) ) ) | ( () ( (lv_bool_6_0= ruleBoolLiteral ) ) ) | (otherlv_7= '(' ( (lv_nestedExpr_8_0= ruleExpression ) ) otherlv_9= ')' ) )
            {
            // InternalReflex.g:2663:2: ( ( (otherlv_0= RULE_ID ) ) | ( () ( (lv_integer_2_0= RULE_INTEGER ) ) ) | ( () ( (lv_floating_4_0= RULE_FLOAT ) ) ) | ( () ( (lv_bool_6_0= ruleBoolLiteral ) ) ) | (otherlv_7= '(' ( (lv_nestedExpr_8_0= ruleExpression ) ) otherlv_9= ')' ) )
            int alt31=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt31=1;
                }
                break;
            case RULE_INTEGER:
                {
                alt31=2;
                }
                break;
            case RULE_FLOAT:
                {
                alt31=3;
                }
                break;
            case 97:
            case 98:
                {
                alt31=4;
                }
                break;
            case 47:
                {
                alt31=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 31, 0, input);

                throw nvae;
            }

            switch (alt31) {
                case 1 :
                    // InternalReflex.g:2664:3: ( (otherlv_0= RULE_ID ) )
                    {
                    // InternalReflex.g:2664:3: ( (otherlv_0= RULE_ID ) )
                    // InternalReflex.g:2665:4: (otherlv_0= RULE_ID )
                    {
                    // InternalReflex.g:2665:4: (otherlv_0= RULE_ID )
                    // InternalReflex.g:2666:5: otherlv_0= RULE_ID
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
                    // InternalReflex.g:2678:3: ( () ( (lv_integer_2_0= RULE_INTEGER ) ) )
                    {
                    // InternalReflex.g:2678:3: ( () ( (lv_integer_2_0= RULE_INTEGER ) ) )
                    // InternalReflex.g:2679:4: () ( (lv_integer_2_0= RULE_INTEGER ) )
                    {
                    // InternalReflex.g:2679:4: ()
                    // InternalReflex.g:2680:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_1_0(),
                      						current);
                      				
                    }

                    }

                    // InternalReflex.g:2686:4: ( (lv_integer_2_0= RULE_INTEGER ) )
                    // InternalReflex.g:2687:5: (lv_integer_2_0= RULE_INTEGER )
                    {
                    // InternalReflex.g:2687:5: (lv_integer_2_0= RULE_INTEGER )
                    // InternalReflex.g:2688:6: lv_integer_2_0= RULE_INTEGER
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
                    // InternalReflex.g:2706:3: ( () ( (lv_floating_4_0= RULE_FLOAT ) ) )
                    {
                    // InternalReflex.g:2706:3: ( () ( (lv_floating_4_0= RULE_FLOAT ) ) )
                    // InternalReflex.g:2707:4: () ( (lv_floating_4_0= RULE_FLOAT ) )
                    {
                    // InternalReflex.g:2707:4: ()
                    // InternalReflex.g:2708:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalReflex.g:2714:4: ( (lv_floating_4_0= RULE_FLOAT ) )
                    // InternalReflex.g:2715:5: (lv_floating_4_0= RULE_FLOAT )
                    {
                    // InternalReflex.g:2715:5: (lv_floating_4_0= RULE_FLOAT )
                    // InternalReflex.g:2716:6: lv_floating_4_0= RULE_FLOAT
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
                    // InternalReflex.g:2734:3: ( () ( (lv_bool_6_0= ruleBoolLiteral ) ) )
                    {
                    // InternalReflex.g:2734:3: ( () ( (lv_bool_6_0= ruleBoolLiteral ) ) )
                    // InternalReflex.g:2735:4: () ( (lv_bool_6_0= ruleBoolLiteral ) )
                    {
                    // InternalReflex.g:2735:4: ()
                    // InternalReflex.g:2736:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getPrimaryExpressionAccess().getPrimaryExpressionAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalReflex.g:2742:4: ( (lv_bool_6_0= ruleBoolLiteral ) )
                    // InternalReflex.g:2743:5: (lv_bool_6_0= ruleBoolLiteral )
                    {
                    // InternalReflex.g:2743:5: (lv_bool_6_0= ruleBoolLiteral )
                    // InternalReflex.g:2744:6: lv_bool_6_0= ruleBoolLiteral
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getBoolBoolLiteralEnumRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_bool_6_0=ruleBoolLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"bool",
                      							lv_bool_6_0,
                      							"ru.iaie.reflex.Reflex.BoolLiteral");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalReflex.g:2763:3: (otherlv_7= '(' ( (lv_nestedExpr_8_0= ruleExpression ) ) otherlv_9= ')' )
                    {
                    // InternalReflex.g:2763:3: (otherlv_7= '(' ( (lv_nestedExpr_8_0= ruleExpression ) ) otherlv_9= ')' )
                    // InternalReflex.g:2764:4: otherlv_7= '(' ( (lv_nestedExpr_8_0= ruleExpression ) ) otherlv_9= ')'
                    {
                    otherlv_7=(Token)match(input,47,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getPrimaryExpressionAccess().getLeftParenthesisKeyword_4_0());
                      			
                    }
                    // InternalReflex.g:2768:4: ( (lv_nestedExpr_8_0= ruleExpression ) )
                    // InternalReflex.g:2769:5: (lv_nestedExpr_8_0= ruleExpression )
                    {
                    // InternalReflex.g:2769:5: (lv_nestedExpr_8_0= ruleExpression )
                    // InternalReflex.g:2770:6: lv_nestedExpr_8_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getPrimaryExpressionAccess().getNestedExprExpressionParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_29);
                    lv_nestedExpr_8_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getPrimaryExpressionRule());
                      						}
                      						set(
                      							current,
                      							"nestedExpr",
                      							lv_nestedExpr_8_0,
                      							"ru.iaie.reflex.Reflex.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_9=(Token)match(input,48,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getPrimaryExpressionAccess().getRightParenthesisKeyword_4_2());
                      			
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
    // InternalReflex.g:2796:1: entryRuleUnaryExpression returns [EObject current=null] : iv_ruleUnaryExpression= ruleUnaryExpression EOF ;
    public final EObject entryRuleUnaryExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnaryExpression = null;


        try {
            // InternalReflex.g:2796:56: (iv_ruleUnaryExpression= ruleUnaryExpression EOF )
            // InternalReflex.g:2797:2: iv_ruleUnaryExpression= ruleUnaryExpression EOF
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
    // InternalReflex.g:2803:1: ruleUnaryExpression returns [EObject current=null] : (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) ) ) ) ;
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
            // InternalReflex.g:2809:2: ( (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) ) ) ) )
            // InternalReflex.g:2810:2: (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) ) ) )
            {
            // InternalReflex.g:2810:2: (this_PrimaryExpression_0= rulePrimaryExpression | this_FunctionCall_1= ruleFunctionCall | this_PostfixOp_2= rulePostfixOp | this_InfixOp_3= ruleInfixOp | ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) ) ) )
            int alt32=5;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                switch ( input.LA(2) ) {
                case EOF:
                case RULE_BIT_AND:
                case RULE_BIT_XOR:
                case RULE_BIT_OR:
                case RULE_LOGICAL_AND:
                case RULE_LOGICAL_OR:
                case 36:
                case 38:
                case 43:
                case 48:
                case 82:
                case 83:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                    {
                    alt32=1;
                    }
                    break;
                case 71:
                case 72:
                    {
                    alt32=3;
                    }
                    break;
                case 47:
                    {
                    alt32=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 32, 1, input);

                    throw nvae;
                }

                }
                break;
            case RULE_INTEGER:
            case RULE_FLOAT:
            case 47:
            case 97:
            case 98:
                {
                alt32=1;
                }
                break;
            case 71:
            case 72:
                {
                alt32=4;
                }
                break;
            case 82:
            case 83:
            case 84:
            case 85:
                {
                alt32=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }

            switch (alt32) {
                case 1 :
                    // InternalReflex.g:2811:3: this_PrimaryExpression_0= rulePrimaryExpression
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
                    // InternalReflex.g:2820:3: this_FunctionCall_1= ruleFunctionCall
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
                    // InternalReflex.g:2829:3: this_PostfixOp_2= rulePostfixOp
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
                    // InternalReflex.g:2838:3: this_InfixOp_3= ruleInfixOp
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
                    // InternalReflex.g:2847:3: ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) ) )
                    {
                    // InternalReflex.g:2847:3: ( ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) ) )
                    // InternalReflex.g:2848:4: ( (lv_unaryOp_4_0= ruleUnaryOp ) ) ( (lv_right_5_0= ruleCastExpression ) )
                    {
                    // InternalReflex.g:2848:4: ( (lv_unaryOp_4_0= ruleUnaryOp ) )
                    // InternalReflex.g:2849:5: (lv_unaryOp_4_0= ruleUnaryOp )
                    {
                    // InternalReflex.g:2849:5: (lv_unaryOp_4_0= ruleUnaryOp )
                    // InternalReflex.g:2850:6: lv_unaryOp_4_0= ruleUnaryOp
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getUnaryExpressionAccess().getUnaryOpUnaryOpEnumRuleCall_4_0_0());
                      					
                    }
                    pushFollow(FOLLOW_27);
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

                    // InternalReflex.g:2867:4: ( (lv_right_5_0= ruleCastExpression ) )
                    // InternalReflex.g:2868:5: (lv_right_5_0= ruleCastExpression )
                    {
                    // InternalReflex.g:2868:5: (lv_right_5_0= ruleCastExpression )
                    // InternalReflex.g:2869:6: lv_right_5_0= ruleCastExpression
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
    // InternalReflex.g:2891:1: entryRuleCastExpression returns [EObject current=null] : iv_ruleCastExpression= ruleCastExpression EOF ;
    public final EObject entryRuleCastExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCastExpression = null;


        try {
            // InternalReflex.g:2891:55: (iv_ruleCastExpression= ruleCastExpression EOF )
            // InternalReflex.g:2892:2: iv_ruleCastExpression= ruleCastExpression EOF
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
    // InternalReflex.g:2898:1: ruleCastExpression returns [EObject current=null] : (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) ) ;
    public final EObject ruleCastExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_UnaryExpression_0 = null;

        EObject lv_type_2_0 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2904:2: ( (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) ) )
            // InternalReflex.g:2905:2: (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) )
            {
            // InternalReflex.g:2905:2: (this_UnaryExpression_0= ruleUnaryExpression | (otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) ) )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( ((LA33_0>=RULE_ID && LA33_0<=RULE_FLOAT)||(LA33_0>=71 && LA33_0<=72)||(LA33_0>=82 && LA33_0<=85)||(LA33_0>=97 && LA33_0<=98)) ) {
                alt33=1;
            }
            else if ( (LA33_0==47) ) {
                int LA33_2 = input.LA(2);

                if ( ((LA33_2>=99 && LA33_2<=107)) ) {
                    alt33=2;
                }
                else if ( ((LA33_2>=RULE_ID && LA33_2<=RULE_FLOAT)||LA33_2==39||LA33_2==47||(LA33_2>=71 && LA33_2<=72)||(LA33_2>=82 && LA33_2<=85)||(LA33_2>=97 && LA33_2<=98)) ) {
                    alt33=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 33, 2, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // InternalReflex.g:2906:3: this_UnaryExpression_0= ruleUnaryExpression
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
                    // InternalReflex.g:2915:3: (otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) )
                    {
                    // InternalReflex.g:2915:3: (otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) ) )
                    // InternalReflex.g:2916:4: otherlv_1= '(' ( (lv_type_2_0= ruleType ) ) otherlv_3= ')' ( (lv_right_4_0= ruleCastExpression ) )
                    {
                    otherlv_1=(Token)match(input,47,FOLLOW_39); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getCastExpressionAccess().getLeftParenthesisKeyword_1_0());
                      			
                    }
                    // InternalReflex.g:2920:4: ( (lv_type_2_0= ruleType ) )
                    // InternalReflex.g:2921:5: (lv_type_2_0= ruleType )
                    {
                    // InternalReflex.g:2921:5: (lv_type_2_0= ruleType )
                    // InternalReflex.g:2922:6: lv_type_2_0= ruleType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCastExpressionAccess().getTypeTypeParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_29);
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

                    otherlv_3=(Token)match(input,48,FOLLOW_27); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getCastExpressionAccess().getRightParenthesisKeyword_1_2());
                      			
                    }
                    // InternalReflex.g:2943:4: ( (lv_right_4_0= ruleCastExpression ) )
                    // InternalReflex.g:2944:5: (lv_right_4_0= ruleCastExpression )
                    {
                    // InternalReflex.g:2944:5: (lv_right_4_0= ruleCastExpression )
                    // InternalReflex.g:2945:6: lv_right_4_0= ruleCastExpression
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
    // InternalReflex.g:2967:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalReflex.g:2967:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalReflex.g:2968:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
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
    // InternalReflex.g:2974:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_CastExpression_0 = null;

        Enumerator lv_mulOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:2980:2: ( (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* ) )
            // InternalReflex.g:2981:2: (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* )
            {
            // InternalReflex.g:2981:2: (this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )* )
            // InternalReflex.g:2982:3: this_CastExpression_0= ruleCastExpression ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getCastExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_47);
            this_CastExpression_0=ruleCastExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CastExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:2990:3: ( () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( ((LA34_0>=94 && LA34_0<=96)) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalReflex.g:2991:4: () ( (lv_mulOp_2_0= ruleMultiplicativeOp ) ) ( (lv_right_3_0= ruleCastExpression ) )
            	    {
            	    // InternalReflex.g:2991:4: ()
            	    // InternalReflex.g:2992:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getMultiplicativeExpressionAccess().getMultiplicativeExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:2998:4: ( (lv_mulOp_2_0= ruleMultiplicativeOp ) )
            	    // InternalReflex.g:2999:5: (lv_mulOp_2_0= ruleMultiplicativeOp )
            	    {
            	    // InternalReflex.g:2999:5: (lv_mulOp_2_0= ruleMultiplicativeOp )
            	    // InternalReflex.g:3000:6: lv_mulOp_2_0= ruleMultiplicativeOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getMulOpMultiplicativeOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_27);
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

            	    // InternalReflex.g:3017:4: ( (lv_right_3_0= ruleCastExpression ) )
            	    // InternalReflex.g:3018:5: (lv_right_3_0= ruleCastExpression )
            	    {
            	    // InternalReflex.g:3018:5: (lv_right_3_0= ruleCastExpression )
            	    // InternalReflex.g:3019:6: lv_right_3_0= ruleCastExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightCastExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_47);
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
            	    break loop34;
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
    // InternalReflex.g:3041:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalReflex.g:3041:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalReflex.g:3042:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
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
    // InternalReflex.g:3048:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject this_MultiplicativeExpression_0 = null;

        Enumerator lv_addOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3054:2: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) )
            // InternalReflex.g:3055:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            {
            // InternalReflex.g:3055:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            // InternalReflex.g:3056:3: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_48);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_MultiplicativeExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3064:3: ( () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
            loop35:
            do {
                int alt35=2;
                int LA35_0 = input.LA(1);

                if ( (LA35_0==82) ) {
                    alt35=1;
                }
                else if ( (LA35_0==83) ) {
                    alt35=1;
                }


                switch (alt35) {
            	case 1 :
            	    // InternalReflex.g:3065:4: () ( (lv_addOp_2_0= ruleAdditiveOp ) ) ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    {
            	    // InternalReflex.g:3065:4: ()
            	    // InternalReflex.g:3066:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAdditiveExpressionAccess().getAdditiveExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:3072:4: ( (lv_addOp_2_0= ruleAdditiveOp ) )
            	    // InternalReflex.g:3073:5: (lv_addOp_2_0= ruleAdditiveOp )
            	    {
            	    // InternalReflex.g:3073:5: (lv_addOp_2_0= ruleAdditiveOp )
            	    // InternalReflex.g:3074:6: lv_addOp_2_0= ruleAdditiveOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getAddOpAdditiveOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_27);
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

            	    // InternalReflex.g:3091:4: ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    // InternalReflex.g:3092:5: (lv_right_3_0= ruleAdditiveExpression )
            	    {
            	    // InternalReflex.g:3092:5: (lv_right_3_0= ruleAdditiveExpression )
            	    // InternalReflex.g:3093:6: lv_right_3_0= ruleAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightAdditiveExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_48);
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
            	    break loop35;
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
    // InternalReflex.g:3115:1: entryRuleShiftExpression returns [EObject current=null] : iv_ruleShiftExpression= ruleShiftExpression EOF ;
    public final EObject entryRuleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleShiftExpression = null;


        try {
            // InternalReflex.g:3115:56: (iv_ruleShiftExpression= ruleShiftExpression EOF )
            // InternalReflex.g:3116:2: iv_ruleShiftExpression= ruleShiftExpression EOF
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
    // InternalReflex.g:3122:1: ruleShiftExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* ) ;
    public final EObject ruleShiftExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AdditiveExpression_0 = null;

        Enumerator lv_shiftOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3128:2: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* ) )
            // InternalReflex.g:3129:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* )
            {
            // InternalReflex.g:3129:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )* )
            // InternalReflex.g:3130:3: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getShiftExpressionAccess().getAdditiveExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_49);
            this_AdditiveExpression_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AdditiveExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3138:3: ( () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==92) ) {
                    alt36=1;
                }
                else if ( (LA36_0==93) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalReflex.g:3139:4: () ( (lv_shiftOp_2_0= ruleShiftOp ) ) ( (lv_right_3_0= ruleShiftExpression ) )
            	    {
            	    // InternalReflex.g:3139:4: ()
            	    // InternalReflex.g:3140:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getShiftExpressionAccess().getShiftExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:3146:4: ( (lv_shiftOp_2_0= ruleShiftOp ) )
            	    // InternalReflex.g:3147:5: (lv_shiftOp_2_0= ruleShiftOp )
            	    {
            	    // InternalReflex.g:3147:5: (lv_shiftOp_2_0= ruleShiftOp )
            	    // InternalReflex.g:3148:6: lv_shiftOp_2_0= ruleShiftOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getShiftExpressionAccess().getShiftOpShiftOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_27);
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

            	    // InternalReflex.g:3165:4: ( (lv_right_3_0= ruleShiftExpression ) )
            	    // InternalReflex.g:3166:5: (lv_right_3_0= ruleShiftExpression )
            	    {
            	    // InternalReflex.g:3166:5: (lv_right_3_0= ruleShiftExpression )
            	    // InternalReflex.g:3167:6: lv_right_3_0= ruleShiftExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getShiftExpressionAccess().getRightShiftExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_49);
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
            	    break loop36;
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
    // InternalReflex.g:3189:1: entryRuleCompareExpression returns [EObject current=null] : iv_ruleCompareExpression= ruleCompareExpression EOF ;
    public final EObject entryRuleCompareExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompareExpression = null;


        try {
            // InternalReflex.g:3189:58: (iv_ruleCompareExpression= ruleCompareExpression EOF )
            // InternalReflex.g:3190:2: iv_ruleCompareExpression= ruleCompareExpression EOF
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
    // InternalReflex.g:3196:1: ruleCompareExpression returns [EObject current=null] : (this_CheckStateExpression_0= ruleCheckStateExpression | (this_ShiftExpression_1= ruleShiftExpression ( () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) ) )* ) ) ;
    public final EObject ruleCompareExpression() throws RecognitionException {
        EObject current = null;

        EObject this_CheckStateExpression_0 = null;

        EObject this_ShiftExpression_1 = null;

        Enumerator lv_cmpOp_3_0 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3202:2: ( (this_CheckStateExpression_0= ruleCheckStateExpression | (this_ShiftExpression_1= ruleShiftExpression ( () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) ) )* ) ) )
            // InternalReflex.g:3203:2: (this_CheckStateExpression_0= ruleCheckStateExpression | (this_ShiftExpression_1= ruleShiftExpression ( () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) ) )* ) )
            {
            // InternalReflex.g:3203:2: (this_CheckStateExpression_0= ruleCheckStateExpression | (this_ShiftExpression_1= ruleShiftExpression ( () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) ) )* ) )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==39) ) {
                alt38=1;
            }
            else if ( ((LA38_0>=RULE_ID && LA38_0<=RULE_FLOAT)||LA38_0==47||(LA38_0>=71 && LA38_0<=72)||(LA38_0>=82 && LA38_0<=85)||(LA38_0>=97 && LA38_0<=98)) ) {
                alt38=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // InternalReflex.g:3204:3: this_CheckStateExpression_0= ruleCheckStateExpression
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
                    // InternalReflex.g:3213:3: (this_ShiftExpression_1= ruleShiftExpression ( () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) ) )* )
                    {
                    // InternalReflex.g:3213:3: (this_ShiftExpression_1= ruleShiftExpression ( () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) ) )* )
                    // InternalReflex.g:3214:4: this_ShiftExpression_1= ruleShiftExpression ( () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) ) )*
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getCompareExpressionAccess().getShiftExpressionParserRuleCall_1_0());
                      			
                    }
                    pushFollow(FOLLOW_50);
                    this_ShiftExpression_1=ruleShiftExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_ShiftExpression_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    // InternalReflex.g:3222:4: ( () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) ) )*
                    loop37:
                    do {
                        int alt37=2;
                        switch ( input.LA(1) ) {
                        case 86:
                            {
                            alt37=1;
                            }
                            break;
                        case 87:
                            {
                            alt37=1;
                            }
                            break;
                        case 88:
                            {
                            alt37=1;
                            }
                            break;
                        case 89:
                            {
                            alt37=1;
                            }
                            break;

                        }

                        switch (alt37) {
                    	case 1 :
                    	    // InternalReflex.g:3223:5: () ( (lv_cmpOp_3_0= ruleCompareOp ) ) ( (lv_right_4_0= ruleCompareExpression ) )
                    	    {
                    	    // InternalReflex.g:3223:5: ()
                    	    // InternalReflex.g:3224:6: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						current = forceCreateModelElementAndSet(
                    	      							grammarAccess.getCompareExpressionAccess().getCompareExpressionLeftAction_1_1_0(),
                    	      							current);
                    	      					
                    	    }

                    	    }

                    	    // InternalReflex.g:3230:5: ( (lv_cmpOp_3_0= ruleCompareOp ) )
                    	    // InternalReflex.g:3231:6: (lv_cmpOp_3_0= ruleCompareOp )
                    	    {
                    	    // InternalReflex.g:3231:6: (lv_cmpOp_3_0= ruleCompareOp )
                    	    // InternalReflex.g:3232:7: lv_cmpOp_3_0= ruleCompareOp
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getCompareExpressionAccess().getCmpOpCompareOpEnumRuleCall_1_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_27);
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

                    	    // InternalReflex.g:3249:5: ( (lv_right_4_0= ruleCompareExpression ) )
                    	    // InternalReflex.g:3250:6: (lv_right_4_0= ruleCompareExpression )
                    	    {
                    	    // InternalReflex.g:3250:6: (lv_right_4_0= ruleCompareExpression )
                    	    // InternalReflex.g:3251:7: lv_right_4_0= ruleCompareExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getCompareExpressionAccess().getRightCompareExpressionParserRuleCall_1_1_2_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_50);
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
                    	    break loop37;
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
    // InternalReflex.g:3274:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalReflex.g:3274:59: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalReflex.g:3275:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
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
    // InternalReflex.g:3281:1: ruleEqualityExpression returns [EObject current=null] : (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject this_CompareExpression_0 = null;

        Enumerator lv_eqCmpOp_2_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3287:2: ( (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) )
            // InternalReflex.g:3288:2: (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            {
            // InternalReflex.g:3288:2: (this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            // InternalReflex.g:3289:3: this_CompareExpression_0= ruleCompareExpression ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEqualityExpressionAccess().getCompareExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_51);
            this_CompareExpression_0=ruleCompareExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_CompareExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3297:3: ( () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==90) ) {
                    alt39=1;
                }
                else if ( (LA39_0==91) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalReflex.g:3298:4: () ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) ) ( (lv_right_3_0= ruleEqualityExpression ) )
            	    {
            	    // InternalReflex.g:3298:4: ()
            	    // InternalReflex.g:3299:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getEqualityExpressionAccess().getEqualityExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalReflex.g:3305:4: ( (lv_eqCmpOp_2_0= ruleCompareEqOp ) )
            	    // InternalReflex.g:3306:5: (lv_eqCmpOp_2_0= ruleCompareEqOp )
            	    {
            	    // InternalReflex.g:3306:5: (lv_eqCmpOp_2_0= ruleCompareEqOp )
            	    // InternalReflex.g:3307:6: lv_eqCmpOp_2_0= ruleCompareEqOp
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEqualityExpressionAccess().getEqCmpOpCompareEqOpEnumRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_27);
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

            	    // InternalReflex.g:3324:4: ( (lv_right_3_0= ruleEqualityExpression ) )
            	    // InternalReflex.g:3325:5: (lv_right_3_0= ruleEqualityExpression )
            	    {
            	    // InternalReflex.g:3325:5: (lv_right_3_0= ruleEqualityExpression )
            	    // InternalReflex.g:3326:6: lv_right_3_0= ruleEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightEqualityExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_51);
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
    // $ANTLR end "ruleEqualityExpression"


    // $ANTLR start "entryRuleBitAndExpression"
    // InternalReflex.g:3348:1: entryRuleBitAndExpression returns [EObject current=null] : iv_ruleBitAndExpression= ruleBitAndExpression EOF ;
    public final EObject entryRuleBitAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitAndExpression = null;


        try {
            // InternalReflex.g:3348:57: (iv_ruleBitAndExpression= ruleBitAndExpression EOF )
            // InternalReflex.g:3349:2: iv_ruleBitAndExpression= ruleBitAndExpression EOF
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
    // InternalReflex.g:3355:1: ruleBitAndExpression returns [EObject current=null] : (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* ) ;
    public final EObject ruleBitAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_BIT_AND_2=null;
        EObject this_EqualityExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3361:2: ( (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* ) )
            // InternalReflex.g:3362:2: (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* )
            {
            // InternalReflex.g:3362:2: (this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )* )
            // InternalReflex.g:3363:3: this_EqualityExpression_0= ruleEqualityExpression ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitAndExpressionAccess().getEqualityExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_52);
            this_EqualityExpression_0=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_EqualityExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3371:3: ( () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==RULE_BIT_AND) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalReflex.g:3372:4: () this_BIT_AND_2= RULE_BIT_AND ( (lv_right_3_0= ruleBitAndExpression ) )
            	    {
            	    // InternalReflex.g:3372:4: ()
            	    // InternalReflex.g:3373:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitAndExpressionAccess().getBitAndExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_BIT_AND_2=(Token)match(input,RULE_BIT_AND,FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_BIT_AND_2, grammarAccess.getBitAndExpressionAccess().getBIT_ANDTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:3383:4: ( (lv_right_3_0= ruleBitAndExpression ) )
            	    // InternalReflex.g:3384:5: (lv_right_3_0= ruleBitAndExpression )
            	    {
            	    // InternalReflex.g:3384:5: (lv_right_3_0= ruleBitAndExpression )
            	    // InternalReflex.g:3385:6: lv_right_3_0= ruleBitAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitAndExpressionAccess().getRightBitAndExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_52);
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
    // $ANTLR end "ruleBitAndExpression"


    // $ANTLR start "entryRuleBitXorExpression"
    // InternalReflex.g:3407:1: entryRuleBitXorExpression returns [EObject current=null] : iv_ruleBitXorExpression= ruleBitXorExpression EOF ;
    public final EObject entryRuleBitXorExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitXorExpression = null;


        try {
            // InternalReflex.g:3407:57: (iv_ruleBitXorExpression= ruleBitXorExpression EOF )
            // InternalReflex.g:3408:2: iv_ruleBitXorExpression= ruleBitXorExpression EOF
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
    // InternalReflex.g:3414:1: ruleBitXorExpression returns [EObject current=null] : (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* ) ;
    public final EObject ruleBitXorExpression() throws RecognitionException {
        EObject current = null;

        Token this_BIT_XOR_2=null;
        EObject this_BitAndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3420:2: ( (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* ) )
            // InternalReflex.g:3421:2: (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* )
            {
            // InternalReflex.g:3421:2: (this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )* )
            // InternalReflex.g:3422:3: this_BitAndExpression_0= ruleBitAndExpression ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitXorExpressionAccess().getBitAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_53);
            this_BitAndExpression_0=ruleBitAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3430:3: ( () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==RULE_BIT_XOR) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalReflex.g:3431:4: () this_BIT_XOR_2= RULE_BIT_XOR ( (lv_right_3_0= ruleBitXorExpression ) )
            	    {
            	    // InternalReflex.g:3431:4: ()
            	    // InternalReflex.g:3432:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitXorExpressionAccess().getBitXorExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_BIT_XOR_2=(Token)match(input,RULE_BIT_XOR,FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_BIT_XOR_2, grammarAccess.getBitXorExpressionAccess().getBIT_XORTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:3442:4: ( (lv_right_3_0= ruleBitXorExpression ) )
            	    // InternalReflex.g:3443:5: (lv_right_3_0= ruleBitXorExpression )
            	    {
            	    // InternalReflex.g:3443:5: (lv_right_3_0= ruleBitXorExpression )
            	    // InternalReflex.g:3444:6: lv_right_3_0= ruleBitXorExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitXorExpressionAccess().getRightBitXorExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_53);
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
    // $ANTLR end "ruleBitXorExpression"


    // $ANTLR start "entryRuleBitOrExpression"
    // InternalReflex.g:3466:1: entryRuleBitOrExpression returns [EObject current=null] : iv_ruleBitOrExpression= ruleBitOrExpression EOF ;
    public final EObject entryRuleBitOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBitOrExpression = null;


        try {
            // InternalReflex.g:3466:56: (iv_ruleBitOrExpression= ruleBitOrExpression EOF )
            // InternalReflex.g:3467:2: iv_ruleBitOrExpression= ruleBitOrExpression EOF
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
    // InternalReflex.g:3473:1: ruleBitOrExpression returns [EObject current=null] : (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* ) ;
    public final EObject ruleBitOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_BIT_OR_2=null;
        EObject this_BitXorExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3479:2: ( (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* ) )
            // InternalReflex.g:3480:2: (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* )
            {
            // InternalReflex.g:3480:2: (this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )* )
            // InternalReflex.g:3481:3: this_BitXorExpression_0= ruleBitXorExpression ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getBitOrExpressionAccess().getBitXorExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_54);
            this_BitXorExpression_0=ruleBitXorExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitXorExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3489:3: ( () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==RULE_BIT_OR) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalReflex.g:3490:4: () this_BIT_OR_2= RULE_BIT_OR ( (lv_right_3_0= ruleBitOrExpression ) )
            	    {
            	    // InternalReflex.g:3490:4: ()
            	    // InternalReflex.g:3491:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getBitOrExpressionAccess().getBitOrExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_BIT_OR_2=(Token)match(input,RULE_BIT_OR,FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_BIT_OR_2, grammarAccess.getBitOrExpressionAccess().getBIT_ORTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:3501:4: ( (lv_right_3_0= ruleBitOrExpression ) )
            	    // InternalReflex.g:3502:5: (lv_right_3_0= ruleBitOrExpression )
            	    {
            	    // InternalReflex.g:3502:5: (lv_right_3_0= ruleBitOrExpression )
            	    // InternalReflex.g:3503:6: lv_right_3_0= ruleBitOrExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getBitOrExpressionAccess().getRightBitOrExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_54);
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
            	    break loop42;
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
    // InternalReflex.g:3525:1: entryRuleLogicalAndExpression returns [EObject current=null] : iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF ;
    public final EObject entryRuleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalAndExpression = null;


        try {
            // InternalReflex.g:3525:61: (iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF )
            // InternalReflex.g:3526:2: iv_ruleLogicalAndExpression= ruleLogicalAndExpression EOF
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
    // InternalReflex.g:3532:1: ruleLogicalAndExpression returns [EObject current=null] : (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* ) ;
    public final EObject ruleLogicalAndExpression() throws RecognitionException {
        EObject current = null;

        Token this_LOGICAL_AND_2=null;
        EObject this_BitOrExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3538:2: ( (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* ) )
            // InternalReflex.g:3539:2: (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* )
            {
            // InternalReflex.g:3539:2: (this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )* )
            // InternalReflex.g:3540:3: this_BitOrExpression_0= ruleBitOrExpression ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getBitOrExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_55);
            this_BitOrExpression_0=ruleBitOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BitOrExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3548:3: ( () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==RULE_LOGICAL_AND) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalReflex.g:3549:4: () this_LOGICAL_AND_2= RULE_LOGICAL_AND ( (lv_right_3_0= ruleLogicalAndExpression ) )
            	    {
            	    // InternalReflex.g:3549:4: ()
            	    // InternalReflex.g:3550:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLogicalAndExpressionAccess().getLogicalAndExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_LOGICAL_AND_2=(Token)match(input,RULE_LOGICAL_AND,FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_LOGICAL_AND_2, grammarAccess.getLogicalAndExpressionAccess().getLOGICAL_ANDTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:3560:4: ( (lv_right_3_0= ruleLogicalAndExpression ) )
            	    // InternalReflex.g:3561:5: (lv_right_3_0= ruleLogicalAndExpression )
            	    {
            	    // InternalReflex.g:3561:5: (lv_right_3_0= ruleLogicalAndExpression )
            	    // InternalReflex.g:3562:6: lv_right_3_0= ruleLogicalAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLogicalAndExpressionAccess().getRightLogicalAndExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_55);
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
            	    break loop43;
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
    // InternalReflex.g:3584:1: entryRuleLogicalOrExpression returns [EObject current=null] : iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF ;
    public final EObject entryRuleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLogicalOrExpression = null;


        try {
            // InternalReflex.g:3584:60: (iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF )
            // InternalReflex.g:3585:2: iv_ruleLogicalOrExpression= ruleLogicalOrExpression EOF
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
    // InternalReflex.g:3591:1: ruleLogicalOrExpression returns [EObject current=null] : (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* ) ;
    public final EObject ruleLogicalOrExpression() throws RecognitionException {
        EObject current = null;

        Token this_LOGICAL_OR_2=null;
        EObject this_LogicalAndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3597:2: ( (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* ) )
            // InternalReflex.g:3598:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* )
            {
            // InternalReflex.g:3598:2: (this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )* )
            // InternalReflex.g:3599:3: this_LogicalAndExpression_0= ruleLogicalAndExpression ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getLogicalAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_56);
            this_LogicalAndExpression_0=ruleLogicalAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_LogicalAndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalReflex.g:3607:3: ( () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==RULE_LOGICAL_OR) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalReflex.g:3608:4: () this_LOGICAL_OR_2= RULE_LOGICAL_OR ( (lv_right_3_0= ruleLogicalOrExpression ) )
            	    {
            	    // InternalReflex.g:3608:4: ()
            	    // InternalReflex.g:3609:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getLogicalOrExpressionAccess().getLogicalOrExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    this_LOGICAL_OR_2=(Token)match(input,RULE_LOGICAL_OR,FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_LOGICAL_OR_2, grammarAccess.getLogicalOrExpressionAccess().getLOGICAL_ORTerminalRuleCall_1_1());
            	      			
            	    }
            	    // InternalReflex.g:3619:4: ( (lv_right_3_0= ruleLogicalOrExpression ) )
            	    // InternalReflex.g:3620:5: (lv_right_3_0= ruleLogicalOrExpression )
            	    {
            	    // InternalReflex.g:3620:5: (lv_right_3_0= ruleLogicalOrExpression )
            	    // InternalReflex.g:3621:6: lv_right_3_0= ruleLogicalOrExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getLogicalOrExpressionAccess().getRightLogicalOrExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_56);
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
    // $ANTLR end "ruleLogicalOrExpression"


    // $ANTLR start "entryRuleAssignmentExpression"
    // InternalReflex.g:3643:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression = null;


        try {
            // InternalReflex.g:3643:61: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // InternalReflex.g:3644:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
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
    // InternalReflex.g:3650:1: ruleAssignmentExpression returns [EObject current=null] : ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) ) )? ( (lv_expr_2_0= ruleLogicalOrExpression ) ) ) ;
    public final EObject ruleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Enumerator lv_assignOp_1_0 = null;

        EObject lv_expr_2_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3656:2: ( ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) ) )? ( (lv_expr_2_0= ruleLogicalOrExpression ) ) ) )
            // InternalReflex.g:3657:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) ) )? ( (lv_expr_2_0= ruleLogicalOrExpression ) ) )
            {
            // InternalReflex.g:3657:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) ) )? ( (lv_expr_2_0= ruleLogicalOrExpression ) ) )
            // InternalReflex.g:3658:3: ( ( (otherlv_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) ) )? ( (lv_expr_2_0= ruleLogicalOrExpression ) )
            {
            // InternalReflex.g:3658:3: ( ( (otherlv_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==RULE_ID) ) {
                int LA45_1 = input.LA(2);

                if ( (LA45_1==45||(LA45_1>=73 && LA45_1<=81)) ) {
                    alt45=1;
                }
            }
            switch (alt45) {
                case 1 :
                    // InternalReflex.g:3659:4: ( (otherlv_0= RULE_ID ) ) ( (lv_assignOp_1_0= ruleAssignOperator ) )
                    {
                    // InternalReflex.g:3659:4: ( (otherlv_0= RULE_ID ) )
                    // InternalReflex.g:3660:5: (otherlv_0= RULE_ID )
                    {
                    // InternalReflex.g:3660:5: (otherlv_0= RULE_ID )
                    // InternalReflex.g:3661:6: otherlv_0= RULE_ID
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAssignmentExpressionRule());
                      						}
                      					
                    }
                    otherlv_0=(Token)match(input,RULE_ID,FOLLOW_57); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(otherlv_0, grammarAccess.getAssignmentExpressionAccess().getAssignVarIdReferenceCrossReference_0_0_0());
                      					
                    }

                    }


                    }

                    // InternalReflex.g:3672:4: ( (lv_assignOp_1_0= ruleAssignOperator ) )
                    // InternalReflex.g:3673:5: (lv_assignOp_1_0= ruleAssignOperator )
                    {
                    // InternalReflex.g:3673:5: (lv_assignOp_1_0= ruleAssignOperator )
                    // InternalReflex.g:3674:6: lv_assignOp_1_0= ruleAssignOperator
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getAssignOpAssignOperatorEnumRuleCall_0_1_0());
                      					
                    }
                    pushFollow(FOLLOW_27);
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

            // InternalReflex.g:3692:3: ( (lv_expr_2_0= ruleLogicalOrExpression ) )
            // InternalReflex.g:3693:4: (lv_expr_2_0= ruleLogicalOrExpression )
            {
            // InternalReflex.g:3693:4: (lv_expr_2_0= ruleLogicalOrExpression )
            // InternalReflex.g:3694:5: lv_expr_2_0= ruleLogicalOrExpression
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
    // InternalReflex.g:3715:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalReflex.g:3715:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalReflex.g:3716:2: iv_ruleExpression= ruleExpression EOF
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
    // InternalReflex.g:3722:1: ruleExpression returns [EObject current=null] : this_AssignmentExpression_0= ruleAssignmentExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AssignmentExpression_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3728:2: (this_AssignmentExpression_0= ruleAssignmentExpression )
            // InternalReflex.g:3729:2: this_AssignmentExpression_0= ruleAssignmentExpression
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


    // $ANTLR start "entryRuleType"
    // InternalReflex.g:3740:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // InternalReflex.g:3740:45: (iv_ruleType= ruleType EOF )
            // InternalReflex.g:3741:2: iv_ruleType= ruleType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleType=ruleType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleType; 
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
    // $ANTLR end "entryRuleType"


    // $ANTLR start "ruleType"
    // InternalReflex.g:3747:1: ruleType returns [EObject current=null] : ( ( (lv_sign_0_0= ruleTypeSignSpec ) )? ( (lv_name_1_0= ruleTypes ) ) ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        Enumerator lv_sign_0_0 = null;

        Enumerator lv_name_1_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3753:2: ( ( ( (lv_sign_0_0= ruleTypeSignSpec ) )? ( (lv_name_1_0= ruleTypes ) ) ) )
            // InternalReflex.g:3754:2: ( ( (lv_sign_0_0= ruleTypeSignSpec ) )? ( (lv_name_1_0= ruleTypes ) ) )
            {
            // InternalReflex.g:3754:2: ( ( (lv_sign_0_0= ruleTypeSignSpec ) )? ( (lv_name_1_0= ruleTypes ) ) )
            // InternalReflex.g:3755:3: ( (lv_sign_0_0= ruleTypeSignSpec ) )? ( (lv_name_1_0= ruleTypes ) )
            {
            // InternalReflex.g:3755:3: ( (lv_sign_0_0= ruleTypeSignSpec ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( ((LA46_0>=106 && LA46_0<=107)) ) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalReflex.g:3756:4: (lv_sign_0_0= ruleTypeSignSpec )
                    {
                    // InternalReflex.g:3756:4: (lv_sign_0_0= ruleTypeSignSpec )
                    // InternalReflex.g:3757:5: lv_sign_0_0= ruleTypeSignSpec
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getTypeAccess().getSignTypeSignSpecEnumRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_39);
                    lv_sign_0_0=ruleTypeSignSpec();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getTypeRule());
                      					}
                      					set(
                      						current,
                      						"sign",
                      						lv_sign_0_0,
                      						"ru.iaie.reflex.Reflex.TypeSignSpec");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalReflex.g:3774:3: ( (lv_name_1_0= ruleTypes ) )
            // InternalReflex.g:3775:4: (lv_name_1_0= ruleTypes )
            {
            // InternalReflex.g:3775:4: (lv_name_1_0= ruleTypes )
            // InternalReflex.g:3776:5: lv_name_1_0= ruleTypes
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypeAccess().getNameTypesEnumRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_name_1_0=ruleTypes();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTypeRule());
              					}
              					set(
              						current,
              						"name",
              						lv_name_1_0,
              						"ru.iaie.reflex.Reflex.Types");
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
    // $ANTLR end "ruleType"


    // $ANTLR start "entryRuleTime"
    // InternalReflex.g:3797:1: entryRuleTime returns [EObject current=null] : iv_ruleTime= ruleTime EOF ;
    public final EObject entryRuleTime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTime = null;


        try {
            // InternalReflex.g:3797:45: (iv_ruleTime= ruleTime EOF )
            // InternalReflex.g:3798:2: iv_ruleTime= ruleTime EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTimeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTime=ruleTime();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTime; 
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
    // $ANTLR end "entryRuleTime"


    // $ANTLR start "ruleTime"
    // InternalReflex.g:3804:1: ruleTime returns [EObject current=null] : ( (lv_ticks_0_0= RULE_INTEGER ) ) ;
    public final EObject ruleTime() throws RecognitionException {
        EObject current = null;

        Token lv_ticks_0_0=null;


        	enterRule();

        try {
            // InternalReflex.g:3810:2: ( ( (lv_ticks_0_0= RULE_INTEGER ) ) )
            // InternalReflex.g:3811:2: ( (lv_ticks_0_0= RULE_INTEGER ) )
            {
            // InternalReflex.g:3811:2: ( (lv_ticks_0_0= RULE_INTEGER ) )
            // InternalReflex.g:3812:3: (lv_ticks_0_0= RULE_INTEGER )
            {
            // InternalReflex.g:3812:3: (lv_ticks_0_0= RULE_INTEGER )
            // InternalReflex.g:3813:4: lv_ticks_0_0= RULE_INTEGER
            {
            lv_ticks_0_0=(Token)match(input,RULE_INTEGER,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_ticks_0_0, grammarAccess.getTimeAccess().getTicksINTEGERTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getTimeRule());
              				}
              				setWithLastConsumed(
              					current,
              					"ticks",
              					lv_ticks_0_0,
              					"ru.iaie.reflex.Reflex.INTEGER");
              			
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
    // $ANTLR end "ruleTime"


    // $ANTLR start "entryRuleAnnotation"
    // InternalReflex.g:3832:1: entryRuleAnnotation returns [EObject current=null] : iv_ruleAnnotation= ruleAnnotation EOF ;
    public final EObject entryRuleAnnotation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAnnotation = null;


        try {
            // InternalReflex.g:3832:51: (iv_ruleAnnotation= ruleAnnotation EOF )
            // InternalReflex.g:3833:2: iv_ruleAnnotation= ruleAnnotation EOF
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
    // InternalReflex.g:3839:1: ruleAnnotation returns [EObject current=null] : ( ( ( (lv_key_0_0= ruleAnnotationKey ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) | ( (lv_key_3_0= ruleAnnotationKey ) ) ) ;
    public final EObject ruleAnnotation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_value_2_0=null;
        AntlrDatatypeRuleToken lv_key_0_0 = null;

        AntlrDatatypeRuleToken lv_key_3_0 = null;



        	enterRule();

        try {
            // InternalReflex.g:3845:2: ( ( ( ( (lv_key_0_0= ruleAnnotationKey ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) | ( (lv_key_3_0= ruleAnnotationKey ) ) ) )
            // InternalReflex.g:3846:2: ( ( ( (lv_key_0_0= ruleAnnotationKey ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) | ( (lv_key_3_0= ruleAnnotationKey ) ) )
            {
            // InternalReflex.g:3846:2: ( ( ( (lv_key_0_0= ruleAnnotationKey ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) ) | ( (lv_key_3_0= ruleAnnotationKey ) ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==RULE_ID) ) {
                switch ( input.LA(2) ) {
                case 66:
                    {
                    int LA47_2 = input.LA(3);

                    if ( (LA47_2==RULE_ID) ) {
                        int LA47_5 = input.LA(4);

                        if ( (LA47_5==53) ) {
                            alt47=1;
                        }
                        else if ( (LA47_5==EOF||LA47_5==33) ) {
                            alt47=2;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 47, 5, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 47, 2, input);

                        throw nvae;
                    }
                    }
                    break;
                case EOF:
                case 33:
                    {
                    alt47=2;
                    }
                    break;
                case 53:
                    {
                    alt47=1;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 47, 1, input);

                    throw nvae;
                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // InternalReflex.g:3847:3: ( ( (lv_key_0_0= ruleAnnotationKey ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
                    {
                    // InternalReflex.g:3847:3: ( ( (lv_key_0_0= ruleAnnotationKey ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) ) )
                    // InternalReflex.g:3848:4: ( (lv_key_0_0= ruleAnnotationKey ) ) otherlv_1= ':' ( (lv_value_2_0= RULE_STRING ) )
                    {
                    // InternalReflex.g:3848:4: ( (lv_key_0_0= ruleAnnotationKey ) )
                    // InternalReflex.g:3849:5: (lv_key_0_0= ruleAnnotationKey )
                    {
                    // InternalReflex.g:3849:5: (lv_key_0_0= ruleAnnotationKey )
                    // InternalReflex.g:3850:6: lv_key_0_0= ruleAnnotationKey
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAnnotationAccess().getKeyAnnotationKeyParserRuleCall_0_0_0());
                      					
                    }
                    pushFollow(FOLLOW_33);
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

                    otherlv_1=(Token)match(input,53,FOLLOW_58); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getAnnotationAccess().getColonKeyword_0_1());
                      			
                    }
                    // InternalReflex.g:3871:4: ( (lv_value_2_0= RULE_STRING ) )
                    // InternalReflex.g:3872:5: (lv_value_2_0= RULE_STRING )
                    {
                    // InternalReflex.g:3872:5: (lv_value_2_0= RULE_STRING )
                    // InternalReflex.g:3873:6: lv_value_2_0= RULE_STRING
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
                    // InternalReflex.g:3891:3: ( (lv_key_3_0= ruleAnnotationKey ) )
                    {
                    // InternalReflex.g:3891:3: ( (lv_key_3_0= ruleAnnotationKey ) )
                    // InternalReflex.g:3892:4: (lv_key_3_0= ruleAnnotationKey )
                    {
                    // InternalReflex.g:3892:4: (lv_key_3_0= ruleAnnotationKey )
                    // InternalReflex.g:3893:5: lv_key_3_0= ruleAnnotationKey
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
    // InternalReflex.g:3914:1: entryRuleAnnotationKey returns [String current=null] : iv_ruleAnnotationKey= ruleAnnotationKey EOF ;
    public final String entryRuleAnnotationKey() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleAnnotationKey = null;


        try {
            // InternalReflex.g:3914:53: (iv_ruleAnnotationKey= ruleAnnotationKey EOF )
            // InternalReflex.g:3915:2: iv_ruleAnnotationKey= ruleAnnotationKey EOF
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
    // InternalReflex.g:3921:1: ruleAnnotationKey returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) | this_ID_3= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleAnnotationKey() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;
        Token this_ID_3=null;


        	enterRule();

        try {
            // InternalReflex.g:3927:2: ( ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) | this_ID_3= RULE_ID ) )
            // InternalReflex.g:3928:2: ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) | this_ID_3= RULE_ID )
            {
            // InternalReflex.g:3928:2: ( (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID ) | this_ID_3= RULE_ID )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_ID) ) {
                int LA48_1 = input.LA(2);

                if ( (LA48_1==66) ) {
                    alt48=1;
                }
                else if ( (LA48_1==EOF||LA48_1==33||LA48_1==53) ) {
                    alt48=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 48, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // InternalReflex.g:3929:3: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
                    {
                    // InternalReflex.g:3929:3: (this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID )
                    // InternalReflex.g:3930:4: this_ID_0= RULE_ID kw= '.' this_ID_2= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_59); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_ID_0);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_ID_0, grammarAccess.getAnnotationKeyAccess().getIDTerminalRuleCall_0_0());
                      			
                    }
                    kw=(Token)match(input,66,FOLLOW_3); if (state.failed) return current;
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
                    // InternalReflex.g:3951:3: this_ID_3= RULE_ID
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


    // $ANTLR start "ruleRegisterType"
    // InternalReflex.g:3962:1: ruleRegisterType returns [Enumerator current=null] : ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) ) ;
    public final Enumerator ruleRegisterType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:3968:2: ( ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) ) )
            // InternalReflex.g:3969:2: ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) )
            {
            // InternalReflex.g:3969:2: ( (enumLiteral_0= 'input' ) | (enumLiteral_1= 'output' ) )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==67) ) {
                alt49=1;
            }
            else if ( (LA49_0==68) ) {
                alt49=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // InternalReflex.g:3970:3: (enumLiteral_0= 'input' )
                    {
                    // InternalReflex.g:3970:3: (enumLiteral_0= 'input' )
                    // InternalReflex.g:3971:4: enumLiteral_0= 'input'
                    {
                    enumLiteral_0=(Token)match(input,67,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterTypeAccess().getINPUTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getRegisterTypeAccess().getINPUTEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:3978:3: (enumLiteral_1= 'output' )
                    {
                    // InternalReflex.g:3978:3: (enumLiteral_1= 'output' )
                    // InternalReflex.g:3979:4: enumLiteral_1= 'output'
                    {
                    enumLiteral_1=(Token)match(input,68,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getRegisterTypeAccess().getOUTPUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getRegisterTypeAccess().getOUTPUTEnumLiteralDeclaration_1());
                      			
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
    // $ANTLR end "ruleRegisterType"


    // $ANTLR start "ruleStateQualifier"
    // InternalReflex.g:3989:1: ruleStateQualifier returns [Enumerator current=null] : ( (enumLiteral_0= 'active' ) | (enumLiteral_1= 'inactive' ) | (enumLiteral_2= 'stop' ) | (enumLiteral_3= 'error' ) ) ;
    public final Enumerator ruleStateQualifier() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalReflex.g:3995:2: ( ( (enumLiteral_0= 'active' ) | (enumLiteral_1= 'inactive' ) | (enumLiteral_2= 'stop' ) | (enumLiteral_3= 'error' ) ) )
            // InternalReflex.g:3996:2: ( (enumLiteral_0= 'active' ) | (enumLiteral_1= 'inactive' ) | (enumLiteral_2= 'stop' ) | (enumLiteral_3= 'error' ) )
            {
            // InternalReflex.g:3996:2: ( (enumLiteral_0= 'active' ) | (enumLiteral_1= 'inactive' ) | (enumLiteral_2= 'stop' ) | (enumLiteral_3= 'error' ) )
            int alt50=4;
            switch ( input.LA(1) ) {
            case 69:
                {
                alt50=1;
                }
                break;
            case 70:
                {
                alt50=2;
                }
                break;
            case 56:
                {
                alt50=3;
                }
                break;
            case 57:
                {
                alt50=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 50, 0, input);

                throw nvae;
            }

            switch (alt50) {
                case 1 :
                    // InternalReflex.g:3997:3: (enumLiteral_0= 'active' )
                    {
                    // InternalReflex.g:3997:3: (enumLiteral_0= 'active' )
                    // InternalReflex.g:3998:4: enumLiteral_0= 'active'
                    {
                    enumLiteral_0=(Token)match(input,69,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getStateQualifierAccess().getACTIVEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getStateQualifierAccess().getACTIVEEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4005:3: (enumLiteral_1= 'inactive' )
                    {
                    // InternalReflex.g:4005:3: (enumLiteral_1= 'inactive' )
                    // InternalReflex.g:4006:4: enumLiteral_1= 'inactive'
                    {
                    enumLiteral_1=(Token)match(input,70,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getStateQualifierAccess().getINACTIVEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getStateQualifierAccess().getINACTIVEEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4013:3: (enumLiteral_2= 'stop' )
                    {
                    // InternalReflex.g:4013:3: (enumLiteral_2= 'stop' )
                    // InternalReflex.g:4014:4: enumLiteral_2= 'stop'
                    {
                    enumLiteral_2=(Token)match(input,56,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getStateQualifierAccess().getSTOPEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getStateQualifierAccess().getSTOPEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:4021:3: (enumLiteral_3= 'error' )
                    {
                    // InternalReflex.g:4021:3: (enumLiteral_3= 'error' )
                    // InternalReflex.g:4022:4: enumLiteral_3= 'error'
                    {
                    enumLiteral_3=(Token)match(input,57,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:4032:1: ruleInfixPostfixOp returns [Enumerator current=null] : ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) ) ;
    public final Enumerator ruleInfixPostfixOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4038:2: ( ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) ) )
            // InternalReflex.g:4039:2: ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) )
            {
            // InternalReflex.g:4039:2: ( (enumLiteral_0= '++' ) | (enumLiteral_1= '--' ) )
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==71) ) {
                alt51=1;
            }
            else if ( (LA51_0==72) ) {
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
                    // InternalReflex.g:4040:3: (enumLiteral_0= '++' )
                    {
                    // InternalReflex.g:4040:3: (enumLiteral_0= '++' )
                    // InternalReflex.g:4041:4: enumLiteral_0= '++'
                    {
                    enumLiteral_0=(Token)match(input,71,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getInfixPostfixOpAccess().getINCEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getInfixPostfixOpAccess().getINCEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4048:3: (enumLiteral_1= '--' )
                    {
                    // InternalReflex.g:4048:3: (enumLiteral_1= '--' )
                    // InternalReflex.g:4049:4: enumLiteral_1= '--'
                    {
                    enumLiteral_1=(Token)match(input,72,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:4059:1: ruleAssignOperator returns [Enumerator current=null] : ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) ) ;
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
            // InternalReflex.g:4065:2: ( ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) ) )
            // InternalReflex.g:4066:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) )
            {
            // InternalReflex.g:4066:2: ( (enumLiteral_0= '=' ) | (enumLiteral_1= '*=' ) | (enumLiteral_2= '/=' ) | (enumLiteral_3= '+=' ) | (enumLiteral_4= '-=' ) | (enumLiteral_5= '<<=' ) | (enumLiteral_6= '>>=' ) | (enumLiteral_7= '&=' ) | (enumLiteral_8= '^=' ) | (enumLiteral_9= '|=' ) )
            int alt52=10;
            switch ( input.LA(1) ) {
            case 45:
                {
                alt52=1;
                }
                break;
            case 73:
                {
                alt52=2;
                }
                break;
            case 74:
                {
                alt52=3;
                }
                break;
            case 75:
                {
                alt52=4;
                }
                break;
            case 76:
                {
                alt52=5;
                }
                break;
            case 77:
                {
                alt52=6;
                }
                break;
            case 78:
                {
                alt52=7;
                }
                break;
            case 79:
                {
                alt52=8;
                }
                break;
            case 80:
                {
                alt52=9;
                }
                break;
            case 81:
                {
                alt52=10;
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
                    // InternalReflex.g:4067:3: (enumLiteral_0= '=' )
                    {
                    // InternalReflex.g:4067:3: (enumLiteral_0= '=' )
                    // InternalReflex.g:4068:4: enumLiteral_0= '='
                    {
                    enumLiteral_0=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getASSIGNEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAssignOperatorAccess().getASSIGNEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4075:3: (enumLiteral_1= '*=' )
                    {
                    // InternalReflex.g:4075:3: (enumLiteral_1= '*=' )
                    // InternalReflex.g:4076:4: enumLiteral_1= '*='
                    {
                    enumLiteral_1=(Token)match(input,73,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getMULEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getAssignOperatorAccess().getMULEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4083:3: (enumLiteral_2= '/=' )
                    {
                    // InternalReflex.g:4083:3: (enumLiteral_2= '/=' )
                    // InternalReflex.g:4084:4: enumLiteral_2= '/='
                    {
                    enumLiteral_2=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getDIVEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getAssignOperatorAccess().getDIVEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:4091:3: (enumLiteral_3= '+=' )
                    {
                    // InternalReflex.g:4091:3: (enumLiteral_3= '+=' )
                    // InternalReflex.g:4092:4: enumLiteral_3= '+='
                    {
                    enumLiteral_3=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getMODEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getAssignOperatorAccess().getMODEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalReflex.g:4099:3: (enumLiteral_4= '-=' )
                    {
                    // InternalReflex.g:4099:3: (enumLiteral_4= '-=' )
                    // InternalReflex.g:4100:4: enumLiteral_4= '-='
                    {
                    enumLiteral_4=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getSUBEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getAssignOperatorAccess().getSUBEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalReflex.g:4107:3: (enumLiteral_5= '<<=' )
                    {
                    // InternalReflex.g:4107:3: (enumLiteral_5= '<<=' )
                    // InternalReflex.g:4108:4: enumLiteral_5= '<<='
                    {
                    enumLiteral_5=(Token)match(input,77,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getCINEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getAssignOperatorAccess().getCINEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalReflex.g:4115:3: (enumLiteral_6= '>>=' )
                    {
                    // InternalReflex.g:4115:3: (enumLiteral_6= '>>=' )
                    // InternalReflex.g:4116:4: enumLiteral_6= '>>='
                    {
                    enumLiteral_6=(Token)match(input,78,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getCOUTEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getAssignOperatorAccess().getCOUTEnumLiteralDeclaration_6());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalReflex.g:4123:3: (enumLiteral_7= '&=' )
                    {
                    // InternalReflex.g:4123:3: (enumLiteral_7= '&=' )
                    // InternalReflex.g:4124:4: enumLiteral_7= '&='
                    {
                    enumLiteral_7=(Token)match(input,79,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getBIT_ANDEnumLiteralDeclaration_7().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_7, grammarAccess.getAssignOperatorAccess().getBIT_ANDEnumLiteralDeclaration_7());
                      			
                    }

                    }


                    }
                    break;
                case 9 :
                    // InternalReflex.g:4131:3: (enumLiteral_8= '^=' )
                    {
                    // InternalReflex.g:4131:3: (enumLiteral_8= '^=' )
                    // InternalReflex.g:4132:4: enumLiteral_8= '^='
                    {
                    enumLiteral_8=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAssignOperatorAccess().getBIT_XOREnumLiteralDeclaration_8().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_8, grammarAccess.getAssignOperatorAccess().getBIT_XOREnumLiteralDeclaration_8());
                      			
                    }

                    }


                    }
                    break;
                case 10 :
                    // InternalReflex.g:4139:3: (enumLiteral_9= '|=' )
                    {
                    // InternalReflex.g:4139:3: (enumLiteral_9= '|=' )
                    // InternalReflex.g:4140:4: enumLiteral_9= '|='
                    {
                    enumLiteral_9=(Token)match(input,81,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:4150:1: ruleUnaryOp returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) ) ;
    public final Enumerator ruleUnaryOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalReflex.g:4156:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) ) )
            // InternalReflex.g:4157:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) )
            {
            // InternalReflex.g:4157:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) | (enumLiteral_2= '~' ) | (enumLiteral_3= '!' ) )
            int alt53=4;
            switch ( input.LA(1) ) {
            case 82:
                {
                alt53=1;
                }
                break;
            case 83:
                {
                alt53=2;
                }
                break;
            case 84:
                {
                alt53=3;
                }
                break;
            case 85:
                {
                alt53=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }

            switch (alt53) {
                case 1 :
                    // InternalReflex.g:4158:3: (enumLiteral_0= '+' )
                    {
                    // InternalReflex.g:4158:3: (enumLiteral_0= '+' )
                    // InternalReflex.g:4159:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,82,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOpAccess().getPLUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getUnaryOpAccess().getPLUSEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4166:3: (enumLiteral_1= '-' )
                    {
                    // InternalReflex.g:4166:3: (enumLiteral_1= '-' )
                    // InternalReflex.g:4167:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,83,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOpAccess().getMINUSEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getUnaryOpAccess().getMINUSEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4174:3: (enumLiteral_2= '~' )
                    {
                    // InternalReflex.g:4174:3: (enumLiteral_2= '~' )
                    // InternalReflex.g:4175:4: enumLiteral_2= '~'
                    {
                    enumLiteral_2=(Token)match(input,84,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getUnaryOpAccess().getBIT_NOTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getUnaryOpAccess().getBIT_NOTEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:4182:3: (enumLiteral_3= '!' )
                    {
                    // InternalReflex.g:4182:3: (enumLiteral_3= '!' )
                    // InternalReflex.g:4183:4: enumLiteral_3= '!'
                    {
                    enumLiteral_3=(Token)match(input,85,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:4193:1: ruleCompareOp returns [Enumerator current=null] : ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) ) ;
    public final Enumerator ruleCompareOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalReflex.g:4199:2: ( ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) ) )
            // InternalReflex.g:4200:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) )
            {
            // InternalReflex.g:4200:2: ( (enumLiteral_0= '<' ) | (enumLiteral_1= '>' ) | (enumLiteral_2= '=<' ) | (enumLiteral_3= '>=' ) )
            int alt54=4;
            switch ( input.LA(1) ) {
            case 86:
                {
                alt54=1;
                }
                break;
            case 87:
                {
                alt54=2;
                }
                break;
            case 88:
                {
                alt54=3;
                }
                break;
            case 89:
                {
                alt54=4;
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
                    // InternalReflex.g:4201:3: (enumLiteral_0= '<' )
                    {
                    // InternalReflex.g:4201:3: (enumLiteral_0= '<' )
                    // InternalReflex.g:4202:4: enumLiteral_0= '<'
                    {
                    enumLiteral_0=(Token)match(input,86,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareOpAccess().getLESSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getCompareOpAccess().getLESSEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4209:3: (enumLiteral_1= '>' )
                    {
                    // InternalReflex.g:4209:3: (enumLiteral_1= '>' )
                    // InternalReflex.g:4210:4: enumLiteral_1= '>'
                    {
                    enumLiteral_1=(Token)match(input,87,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareOpAccess().getGREATEREnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getCompareOpAccess().getGREATEREnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4217:3: (enumLiteral_2= '=<' )
                    {
                    // InternalReflex.g:4217:3: (enumLiteral_2= '=<' )
                    // InternalReflex.g:4218:4: enumLiteral_2= '=<'
                    {
                    enumLiteral_2=(Token)match(input,88,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareOpAccess().getLESS_EQEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getCompareOpAccess().getLESS_EQEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:4225:3: (enumLiteral_3= '>=' )
                    {
                    // InternalReflex.g:4225:3: (enumLiteral_3= '>=' )
                    // InternalReflex.g:4226:4: enumLiteral_3= '>='
                    {
                    enumLiteral_3=(Token)match(input,89,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:4236:1: ruleCompareEqOp returns [Enumerator current=null] : ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) ) ;
    public final Enumerator ruleCompareEqOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4242:2: ( ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) ) )
            // InternalReflex.g:4243:2: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) )
            {
            // InternalReflex.g:4243:2: ( (enumLiteral_0= '==' ) | (enumLiteral_1= '!=' ) )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==90) ) {
                alt55=1;
            }
            else if ( (LA55_0==91) ) {
                alt55=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // InternalReflex.g:4244:3: (enumLiteral_0= '==' )
                    {
                    // InternalReflex.g:4244:3: (enumLiteral_0= '==' )
                    // InternalReflex.g:4245:4: enumLiteral_0= '=='
                    {
                    enumLiteral_0=(Token)match(input,90,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getCompareEqOpAccess().getEQEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getCompareEqOpAccess().getEQEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4252:3: (enumLiteral_1= '!=' )
                    {
                    // InternalReflex.g:4252:3: (enumLiteral_1= '!=' )
                    // InternalReflex.g:4253:4: enumLiteral_1= '!='
                    {
                    enumLiteral_1=(Token)match(input,91,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:4263:1: ruleShiftOp returns [Enumerator current=null] : ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) ) ;
    public final Enumerator ruleShiftOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4269:2: ( ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) ) )
            // InternalReflex.g:4270:2: ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) )
            {
            // InternalReflex.g:4270:2: ( (enumLiteral_0= '>>' ) | (enumLiteral_1= '<<' ) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==92) ) {
                alt56=1;
            }
            else if ( (LA56_0==93) ) {
                alt56=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // InternalReflex.g:4271:3: (enumLiteral_0= '>>' )
                    {
                    // InternalReflex.g:4271:3: (enumLiteral_0= '>>' )
                    // InternalReflex.g:4272:4: enumLiteral_0= '>>'
                    {
                    enumLiteral_0=(Token)match(input,92,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getShiftOpAccess().getLEFT_SHIFTEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getShiftOpAccess().getLEFT_SHIFTEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4279:3: (enumLiteral_1= '<<' )
                    {
                    // InternalReflex.g:4279:3: (enumLiteral_1= '<<' )
                    // InternalReflex.g:4280:4: enumLiteral_1= '<<'
                    {
                    enumLiteral_1=(Token)match(input,93,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:4290:1: ruleAdditiveOp returns [Enumerator current=null] : ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) ;
    public final Enumerator ruleAdditiveOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4296:2: ( ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) ) )
            // InternalReflex.g:4297:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            {
            // InternalReflex.g:4297:2: ( (enumLiteral_0= '+' ) | (enumLiteral_1= '-' ) )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==82) ) {
                alt57=1;
            }
            else if ( (LA57_0==83) ) {
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
                    // InternalReflex.g:4298:3: (enumLiteral_0= '+' )
                    {
                    // InternalReflex.g:4298:3: (enumLiteral_0= '+' )
                    // InternalReflex.g:4299:4: enumLiteral_0= '+'
                    {
                    enumLiteral_0=(Token)match(input,82,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getAdditiveOpAccess().getPLUSEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getAdditiveOpAccess().getPLUSEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4306:3: (enumLiteral_1= '-' )
                    {
                    // InternalReflex.g:4306:3: (enumLiteral_1= '-' )
                    // InternalReflex.g:4307:4: enumLiteral_1= '-'
                    {
                    enumLiteral_1=(Token)match(input,83,FOLLOW_2); if (state.failed) return current;
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
    // InternalReflex.g:4317:1: ruleMultiplicativeOp returns [Enumerator current=null] : ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) ;
    public final Enumerator ruleMultiplicativeOp() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalReflex.g:4323:2: ( ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) ) )
            // InternalReflex.g:4324:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            {
            // InternalReflex.g:4324:2: ( (enumLiteral_0= '*' ) | (enumLiteral_1= '/' ) | (enumLiteral_2= '%' ) )
            int alt58=3;
            switch ( input.LA(1) ) {
            case 94:
                {
                alt58=1;
                }
                break;
            case 95:
                {
                alt58=2;
                }
                break;
            case 96:
                {
                alt58=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // InternalReflex.g:4325:3: (enumLiteral_0= '*' )
                    {
                    // InternalReflex.g:4325:3: (enumLiteral_0= '*' )
                    // InternalReflex.g:4326:4: enumLiteral_0= '*'
                    {
                    enumLiteral_0=(Token)match(input,94,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplicativeOpAccess().getMULEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getMultiplicativeOpAccess().getMULEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4333:3: (enumLiteral_1= '/' )
                    {
                    // InternalReflex.g:4333:3: (enumLiteral_1= '/' )
                    // InternalReflex.g:4334:4: enumLiteral_1= '/'
                    {
                    enumLiteral_1=(Token)match(input,95,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getMultiplicativeOpAccess().getDIVEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getMultiplicativeOpAccess().getDIVEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4341:3: (enumLiteral_2= '%' )
                    {
                    // InternalReflex.g:4341:3: (enumLiteral_2= '%' )
                    // InternalReflex.g:4342:4: enumLiteral_2= '%'
                    {
                    enumLiteral_2=(Token)match(input,96,FOLLOW_2); if (state.failed) return current;
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


    // $ANTLR start "ruleBoolLiteral"
    // InternalReflex.g:4352:1: ruleBoolLiteral returns [Enumerator current=null] : ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) ) ;
    public final Enumerator ruleBoolLiteral() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4358:2: ( ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) ) )
            // InternalReflex.g:4359:2: ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) )
            {
            // InternalReflex.g:4359:2: ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) )
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==97) ) {
                alt59=1;
            }
            else if ( (LA59_0==98) ) {
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
                    // InternalReflex.g:4360:3: (enumLiteral_0= 'true' )
                    {
                    // InternalReflex.g:4360:3: (enumLiteral_0= 'true' )
                    // InternalReflex.g:4361:4: enumLiteral_0= 'true'
                    {
                    enumLiteral_0=(Token)match(input,97,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getBoolLiteralAccess().getTRUEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getBoolLiteralAccess().getTRUEEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4368:3: (enumLiteral_1= 'false' )
                    {
                    // InternalReflex.g:4368:3: (enumLiteral_1= 'false' )
                    // InternalReflex.g:4369:4: enumLiteral_1= 'false'
                    {
                    enumLiteral_1=(Token)match(input,98,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getBoolLiteralAccess().getFALSEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getBoolLiteralAccess().getFALSEEnumLiteralDeclaration_1());
                      			
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
    // $ANTLR end "ruleBoolLiteral"


    // $ANTLR start "ruleTypes"
    // InternalReflex.g:4379:1: ruleTypes returns [Enumerator current=null] : ( (enumLiteral_0= 'void' ) | (enumLiteral_1= 'float' ) | (enumLiteral_2= 'double' ) | (enumLiteral_3= 'short' ) | (enumLiteral_4= 'int' ) | (enumLiteral_5= 'long' ) | (enumLiteral_6= 'bool' ) ) ;
    public final Enumerator ruleTypes() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;


        	enterRule();

        try {
            // InternalReflex.g:4385:2: ( ( (enumLiteral_0= 'void' ) | (enumLiteral_1= 'float' ) | (enumLiteral_2= 'double' ) | (enumLiteral_3= 'short' ) | (enumLiteral_4= 'int' ) | (enumLiteral_5= 'long' ) | (enumLiteral_6= 'bool' ) ) )
            // InternalReflex.g:4386:2: ( (enumLiteral_0= 'void' ) | (enumLiteral_1= 'float' ) | (enumLiteral_2= 'double' ) | (enumLiteral_3= 'short' ) | (enumLiteral_4= 'int' ) | (enumLiteral_5= 'long' ) | (enumLiteral_6= 'bool' ) )
            {
            // InternalReflex.g:4386:2: ( (enumLiteral_0= 'void' ) | (enumLiteral_1= 'float' ) | (enumLiteral_2= 'double' ) | (enumLiteral_3= 'short' ) | (enumLiteral_4= 'int' ) | (enumLiteral_5= 'long' ) | (enumLiteral_6= 'bool' ) )
            int alt60=7;
            switch ( input.LA(1) ) {
            case 99:
                {
                alt60=1;
                }
                break;
            case 100:
                {
                alt60=2;
                }
                break;
            case 101:
                {
                alt60=3;
                }
                break;
            case 102:
                {
                alt60=4;
                }
                break;
            case 103:
                {
                alt60=5;
                }
                break;
            case 104:
                {
                alt60=6;
                }
                break;
            case 105:
                {
                alt60=7;
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
                    // InternalReflex.g:4387:3: (enumLiteral_0= 'void' )
                    {
                    // InternalReflex.g:4387:3: (enumLiteral_0= 'void' )
                    // InternalReflex.g:4388:4: enumLiteral_0= 'void'
                    {
                    enumLiteral_0=(Token)match(input,99,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypesAccess().getVOID_C_TYPEEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getTypesAccess().getVOID_C_TYPEEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4395:3: (enumLiteral_1= 'float' )
                    {
                    // InternalReflex.g:4395:3: (enumLiteral_1= 'float' )
                    // InternalReflex.g:4396:4: enumLiteral_1= 'float'
                    {
                    enumLiteral_1=(Token)match(input,100,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypesAccess().getFLOAT_C_TYPEEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getTypesAccess().getFLOAT_C_TYPEEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalReflex.g:4403:3: (enumLiteral_2= 'double' )
                    {
                    // InternalReflex.g:4403:3: (enumLiteral_2= 'double' )
                    // InternalReflex.g:4404:4: enumLiteral_2= 'double'
                    {
                    enumLiteral_2=(Token)match(input,101,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypesAccess().getDOUBLE_C_TYPEEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getTypesAccess().getDOUBLE_C_TYPEEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalReflex.g:4411:3: (enumLiteral_3= 'short' )
                    {
                    // InternalReflex.g:4411:3: (enumLiteral_3= 'short' )
                    // InternalReflex.g:4412:4: enumLiteral_3= 'short'
                    {
                    enumLiteral_3=(Token)match(input,102,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypesAccess().getSHORT_C_TYPEEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getTypesAccess().getSHORT_C_TYPEEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalReflex.g:4419:3: (enumLiteral_4= 'int' )
                    {
                    // InternalReflex.g:4419:3: (enumLiteral_4= 'int' )
                    // InternalReflex.g:4420:4: enumLiteral_4= 'int'
                    {
                    enumLiteral_4=(Token)match(input,103,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypesAccess().getINT_C_TYPEEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getTypesAccess().getINT_C_TYPEEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;
                case 6 :
                    // InternalReflex.g:4427:3: (enumLiteral_5= 'long' )
                    {
                    // InternalReflex.g:4427:3: (enumLiteral_5= 'long' )
                    // InternalReflex.g:4428:4: enumLiteral_5= 'long'
                    {
                    enumLiteral_5=(Token)match(input,104,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypesAccess().getLONG_C_TYPEEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_5, grammarAccess.getTypesAccess().getLONG_C_TYPEEnumLiteralDeclaration_5());
                      			
                    }

                    }


                    }
                    break;
                case 7 :
                    // InternalReflex.g:4435:3: (enumLiteral_6= 'bool' )
                    {
                    // InternalReflex.g:4435:3: (enumLiteral_6= 'bool' )
                    // InternalReflex.g:4436:4: enumLiteral_6= 'bool'
                    {
                    enumLiteral_6=(Token)match(input,105,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypesAccess().getBOOL_TYPEEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_6, grammarAccess.getTypesAccess().getBOOL_TYPEEnumLiteralDeclaration_6());
                      			
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
    // $ANTLR end "ruleTypes"


    // $ANTLR start "ruleTypeSignSpec"
    // InternalReflex.g:4446:1: ruleTypeSignSpec returns [Enumerator current=null] : ( (enumLiteral_0= 'signed' ) | (enumLiteral_1= 'unsigned' ) ) ;
    public final Enumerator ruleTypeSignSpec() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalReflex.g:4452:2: ( ( (enumLiteral_0= 'signed' ) | (enumLiteral_1= 'unsigned' ) ) )
            // InternalReflex.g:4453:2: ( (enumLiteral_0= 'signed' ) | (enumLiteral_1= 'unsigned' ) )
            {
            // InternalReflex.g:4453:2: ( (enumLiteral_0= 'signed' ) | (enumLiteral_1= 'unsigned' ) )
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==106) ) {
                alt61=1;
            }
            else if ( (LA61_0==107) ) {
                alt61=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 61, 0, input);

                throw nvae;
            }
            switch (alt61) {
                case 1 :
                    // InternalReflex.g:4454:3: (enumLiteral_0= 'signed' )
                    {
                    // InternalReflex.g:4454:3: (enumLiteral_0= 'signed' )
                    // InternalReflex.g:4455:4: enumLiteral_0= 'signed'
                    {
                    enumLiteral_0=(Token)match(input,106,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeSignSpecAccess().getSIGNEDEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getTypeSignSpecAccess().getSIGNEDEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalReflex.g:4462:3: (enumLiteral_1= 'unsigned' )
                    {
                    // InternalReflex.g:4462:3: (enumLiteral_1= 'unsigned' )
                    // InternalReflex.g:4463:4: enumLiteral_1= 'unsigned'
                    {
                    enumLiteral_1=(Token)match(input,107,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTypeSignSpecAccess().getUNSIGNEDEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getTypeSignSpecAccess().getUNSIGNEDEnumLiteralDeclaration_1());
                      			
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
    // $ANTLR end "ruleTypeSignSpec"

    // $ANTLR start synpred1_InternalReflex
    public final void synpred1_InternalReflex_fragment() throws RecognitionException {   
        // InternalReflex.g:1399:5: ( 'else' )
        // InternalReflex.g:1399:6: 'else'
        {
        match(input,50,FOLLOW_2); if (state.failed) return ;

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


    protected DFA3 dfa3 = new DFA3(this);
    protected DFA12 dfa12 = new DFA12(this);
    protected DFA14 dfa14 = new DFA14(this);
    static final String dfa_1s = "\22\uffff";
    static final String dfa_2s = "\1\40\3\uffff\2\143\7\4\2\uffff\1\46\2\uffff";
    static final String dfa_3s = "\1\153\3\uffff\2\151\7\4\2\uffff\1\57\2\uffff";
    static final String dfa_4s = "\1\uffff\1\7\1\1\1\2\11\uffff\1\5\1\6\1\uffff\1\4\1\3";
    static final String dfa_5s = "\22\uffff}>";
    static final String[] dfa_6s = {
            "\1\16\3\uffff\1\1\2\uffff\1\16\27\uffff\1\2\1\3\2\uffff\2\15\36\uffff\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\4\1\5",
            "",
            "",
            "",
            "\1\6\1\7\1\10\1\11\1\12\1\13\1\14",
            "\1\6\1\7\1\10\1\11\1\12\1\13\1\14",
            "\1\17",
            "\1\17",
            "\1\17",
            "\1\17",
            "\1\17",
            "\1\17",
            "\1\17",
            "",
            "",
            "\1\20\6\uffff\1\20\1\uffff\1\21",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final char[] dfa_2 = DFA.unpackEncodedStringToUnsignedChars(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final short[] dfa_4 = DFA.unpackEncodedString(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[][] dfa_6 = unpackEncodedStringArray(dfa_6s);

    class DFA3 extends DFA {

        public DFA3(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 3;
            this.eot = dfa_1;
            this.eof = dfa_1;
            this.min = dfa_2;
            this.max = dfa_3;
            this.accept = dfa_4;
            this.special = dfa_5;
            this.transition = dfa_6;
        }
        public String getDescription() {
            return "()* loopback of 154:3: ( ( (lv_consts_7_0= ruleConst ) ) | ( (lv_enums_8_0= ruleEnum ) ) | ( (lv_functions_9_0= ruleFunction ) ) | ( (lv_globalVars_10_0= ruleGlobalVariable ) ) | ( (lv_registers_11_0= ruleRegister ) ) | ( (lv_processes_12_0= ruleProcess ) ) )*";
        }
    }
    static final String dfa_7s = "\15\uffff";
    static final String dfa_8s = "\12\uffff\1\14\2\uffff";
    static final String dfa_9s = "\3\143\7\4\1\46\2\uffff";
    static final String dfa_10s = "\1\153\2\151\7\4\1\55\2\uffff";
    static final String dfa_11s = "\13\uffff\1\1\1\2";
    static final String dfa_12s = "\15\uffff}>";
    static final String[] dfa_13s = {
            "\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\1\1\2",
            "\1\3\1\4\1\5\1\6\1\7\1\10\1\11",
            "\1\3\1\4\1\5\1\6\1\7\1\10\1\11",
            "\1\12",
            "\1\12",
            "\1\12",
            "\1\12",
            "\1\12",
            "\1\12",
            "\1\12",
            "\1\14\3\uffff\1\14\2\uffff\1\13",
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

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = dfa_7;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "709:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable )";
        }
    }
    static final String dfa_14s = "\13\uffff\1\2\1\1";
    static final String[] dfa_15s = {
            "\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\1\1\2",
            "\1\3\1\4\1\5\1\6\1\7\1\10\1\11",
            "\1\3\1\4\1\5\1\6\1\7\1\10\1\11",
            "\1\12",
            "\1\12",
            "\1\12",
            "\1\12",
            "\1\12",
            "\1\12",
            "\1\12",
            "\1\13\6\uffff\1\14",
            "",
            ""
    };
    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final short[][] dfa_15 = unpackEncodedStringArray(dfa_15s);

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = dfa_7;
            this.eof = dfa_7;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_14;
            this.special = dfa_12;
            this.transition = dfa_15;
        }
        public String getDescription() {
            return "761:3: (this_PhysicalVariable_0= rulePhysicalVariable | this_ProgramVariable_1= ruleProgramVariable )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000500000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x800000B100000000L,0x00000FF800000019L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x8000009100000000L,0x00000FF800000019L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000008100000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000051100000000L,0x00000FF800000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000011100000000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000010100000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000020800000000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x2F8AC0D800000070L,0x00000006003C0180L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000401000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000180000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000040000000002L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x2F8A80C800000072L,0x00000006003C0180L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x2F8A80D800000070L,0x00000006003C0180L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000800000000030L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x2F8A80C800000070L,0x00000006003C0180L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0010001000000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x2FCA80C800000070L,0x00000006003C0180L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x000000C000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x4000010000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000000L,0x00000FF800000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0001080000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000081000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000180L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x2F8B80C800000070L,0x00000006003C0180L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0300000000000000L,0x0000000000000060L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000002L,0x00000001C0000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000002L,0x00000000000C0000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000002L,0x0000000030000000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000002L,0x0000000003C00000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000002L,0x000000000C000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000102L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000202L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000200000000000L,0x000000000003FE00L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});

}